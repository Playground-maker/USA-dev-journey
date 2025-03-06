const readline = require("readline"); // 백준 입력

function solution(data) {
    const [sizeX, sizeY] = data.shift().split(" ");
    const board = data.map((val) => val.split(" ").map(Number));
    let visited = board.map((val) => val.map(() => false));
    let isEmpty = [];
    let firstQueue = [];
    let queue = [];

    let direction = [
        [0, 1],
        [1, 0],
        [0, -1],
        [-1, 0],
    ];

    let answer = 0;
    let plusVirus = 0;
    let total;

    for (let i = 0; i < sizeX; i++) {
        for (let j = 0; j < sizeY; j++) {
            if (board[i][j] === 0) isEmpty.push([i, j]);
            if (board[i][j] === 2) {
                firstQueue.push([i, j]);
            }
        }
    }

    for (let i = 0; i < isEmpty.length; i++) {
        board[isEmpty[i][0]][isEmpty[i][1]] = 1;
        for (let j = i; j < isEmpty.length; j++) {
            if (i === j) continue;
            board[isEmpty[j][0]][isEmpty[j][1]] = 1;
            for (let k = j; k < isEmpty.length; k++) {
                if (i === k || j === k) continue;
                board[isEmpty[k][0]][isEmpty[k][1]] = 1;
                visited[isEmpty[i][0][isEmpty[i][1]]] = true;
                visited[isEmpty[j][0][isEmpty[j][1]]] = true;
                visited[isEmpty[k][0][isEmpty[k][1]]] = true;
                queue = [...firstQueue];
                bfs();
                visited = board.map((val) => val.map(() => false));
                board[isEmpty[k][0]][isEmpty[k][1]] = 0;
            }
            board[isEmpty[j][0]][isEmpty[j][1]] = 0;
        }
        board[isEmpty[i][0]][isEmpty[i][1]] = 0;
    }

    function bfs() {
        while (queue.length > 0) {
            let [nowX, nowY] = queue.shift();
            direction.forEach(([dx, dy]) => {
                let [nextX, nextY] = [nowX + dx, nowY + dy];
                if (nextX < 0 || nextY < 0 || nextX >= sizeX || nextY >= sizeY) return;
                if (visited[nextX][nextY] === false && board[nextX][nextY] === 0) {
                    visited[nextX][nextY] = true;
                    plusVirus = plusVirus + 1;
                    queue.push([nextX, nextY]);
                }
            });
        }
        total = isEmpty.length - 3 - plusVirus;
        if (total > answer) answer = total;
        plusVirus = 0;
    }

    return answer;
}

const input = [];
readline
    .createInterface({
        input: process.stdin,
        output: process.stdout,
    })
    .on("line", (line) => {
        input.push(line);
    })
    .on("close", () => {
        console.log(solution(input));
    });

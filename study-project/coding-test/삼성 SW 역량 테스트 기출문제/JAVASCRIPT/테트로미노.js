const readline = require("readline");

function solution(input) {
    let boardSize = input.shift();
    let [boardx, boardy] = boardSize.split(" ");
    let board = input.map((val) => {
        let arr = val.split(" ");
        let numArr = arr.map((val) => Number(val));
        return numArr;
    });
    let visited = Array.from({ length: boardx }, () => Array.from({ length: boardy }, () => false));
    let answer = 0;

    let direction = [
        [0, 1],
        [-1, 0],
        [0, -1],
        [1, 0],
    ];

    for (let i = 0; i < boardx; i++) {
        for (let j = 0; j < boardy; j++) {
            visited[i][j] = true;
            dfs([i, j], 1, board[i][j]);
            visited[i][j] = false;
        }
    }

    function dfs(nowPos, depth, total) {
        if (depth === 4) {
            if (total > answer) answer = total;
            return;
        }
        if (depth === 2) {
            for (let i = 0; i < 4; i++) {
                let first = i;
                let second = i === 3 ? 0 : i + 1;
                let [nowx, nowy] = nowPos;
                let [onex, oney] = [nowx + direction[first][0], nowy + direction[first][1]];
                let [twox, twoy] = [nowx + direction[second][0], nowy + direction[second][1]];

                if (
                    onex >= 0 &&
                    oney >= 0 &&
                    twox >= 0 &&
                    twoy >= 0 &&
                    onex < boardx &&
                    oney < boardy &&
                    twox < boardx &&
                    twoy < boardy &&
                    visited[onex][oney] === false &&
                    visited[twox][twoy] === false
                ) {
                    let newTotal = total + board[onex][oney] + board[twox][twoy];
                    if (newTotal > answer) answer = newTotal;
                }
            }
        }
        direction.forEach(([dx, dy]) => {
            let [nowx, nowy] = nowPos;
            let [newx, newy] = [nowx + dx, nowy + dy];
            if (newx >= 0 && newy >= 0 && newx < boardx && newy < boardy && visited[newx][newy] === false) {
                visited[newx][newy] = true;
                let newPos = [newx, newy];
                let newDepth = depth + 1;
                let newTotal = total + board[newx][newy];
                dfs(newPos, newDepth, newTotal);
                visited[newx][newy] = false;
            }
        });
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

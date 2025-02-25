const readline = require("readline");

function solution(input) {
    const [n, ...boardInput] = input;
    const [N, M] = n.split(" ").map(Number);
    const board = boardInput.map((row) => row.split(""));

    const directions = [
        [0, 1],
        [0, -1],
        [1, 0],
        [-1, 0],
    ];

    let redPos, bluePos;

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (board[i][j] === "R") redPos = [i, j];
            if (board[i][j] === "B") bluePos = [i, j];
        }
    }

    const move = (x, y, dx, dy) => {
        let count = 0;
        while (board[x + dx][y + dy] !== "#" && board[x][y] !== "O") {
            x += dx;
            y += dy;
            count++;
        }
        return [x, y, count];
    };

    const queue = [[...redPos, ...bluePos, 0]];
    const visited = new Set();
    visited.add(`${redPos[0]},${redPos[1]},${bluePos[0]},${bluePos[1]}`);

    while (queue.length > 0) {
        const [rx, ry, bx, by, depth] = queue.shift();

        if (depth >= 10) return -1;

        for (const [dx, dy] of directions) {
            let [nrx, nry, redMoves] = move(rx, ry, dx, dy);
            let [nbx, nby, blueMoves] = move(bx, by, dx, dy);

            if (board[nbx][nby] === "O") continue;
            if (board[nrx][nry] === "O") return depth + 1;

            if (nrx === nbx && nry === nby) {
                if (redMoves > blueMoves) {
                    nrx -= dx;
                    nry -= dy;
                } else {
                    nbx -= dx;
                    nby -= dy;
                }
            }

            const state = `${nrx},${nry},${nbx},${nby}`;
            if (!visited.has(state)) {
                visited.add(state);
                queue.push([nrx, nry, nbx, nby, depth + 1]);
            }
        }
    }

    return -1;
}

// 백준 입력 처리
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

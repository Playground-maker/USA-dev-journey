const readline = require("readline");

function solution(input) {
    let [roomX, roomY] = input.shift().split(" ").map(Number);
    let [x, y, d] = input.shift().split(" ").map(Number);
    let room = input.map((val) => val.split(" ").map(Number));

    const direction = [
        [-1, 0],
        [0, 1],
        [1, 0],
        [0, -1],
    ];

    let cleaned = Array.from({ length: roomX }, () => Array(roomY).fill(false));
    let count = 0;

    while (true) {
        if (!cleaned[x][y]) {
            cleaned[x][y] = true;
            count++;
        }

        let found = false;

        for (let i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            let dx = x + direction[d][0];
            let dy = y + direction[d][1];
            if (room[dx][dy] === 0 && !cleaned[dx][dy]) {
                x = dx;
                y = dy;
                found = true;
                break;
            }
        }

        if (!found) {
            let backDir = (d + 2) % 4;
            let dx = x + direction[backDir][0];
            let dy = y + direction[backDir][1];
            if (room[dx][dy] === 1) {
                break;
            } else {
                x = dx;
                y = dy;
            }
        }
    }

    return count;
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

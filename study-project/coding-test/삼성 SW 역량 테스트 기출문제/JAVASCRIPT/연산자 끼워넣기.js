const readline = require("readline");

function solution(input) {
    let dataLength = Number(input[0]);
    let data = input[1].split(" ").map(Number);
    let op = input[2].split(" ").map(Number);
    let min = Number.MAX_SAFE_INTEGER;
    let max = Number.MIN_SAFE_INTEGER;

    function dfs(total, depth) {
        if (depth === dataLength) {
            min > total ? (min = total) : null;
            max < total ? (max = total) : null;
            return;
        }
        for (let i = 0; i < 4; i++) {
            if (op[i] !== 0) {
                op[i]--;
                let nextTotal = cal(total, data[depth], i);
                dfs(nextTotal, depth + 1);
                op[i]++;
            }
        }
    }

    function cal(now, next, op) {
        switch (op) {
            case 0:
                return now + next;
            case 1:
                return now - next;
            case 2:
                return now * next;
            case 3:
                return Math.trunc(now / next);
        }
    }

    dfs(data[0], 1);

    return `${max}\n${min}`;
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

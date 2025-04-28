const readline = require("readline");

function solution(input) {
    let num = Number(input[0]);
    let box = 1;
    let count = 1;

    while (num > box) {
        box += 6 * count;
        count += 1;
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

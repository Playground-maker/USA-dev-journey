const readline = require("readline");

let dp = [0, 1, 2, 1, 2, 1];

const solution = (input) => {
    return input % 2 === 0 ? "CY" : "SK";
};

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
        console.log(solution(Number(input[0])));
    });

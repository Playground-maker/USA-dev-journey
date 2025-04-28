const readline = require("readline");

function solution(input) {
    let data = input.map((val) => val.split(" ").map(Number));
    let answer = [];

    data.forEach((val, idx) => {
        if (idx === data.length - 1) return;
        val.sort((a, b) => b - a);
        let [a, b, c] = val;
        if (a >= b + c) {
            answer.push("Invalid");
        } else {
            if (a === b && b === c) answer.push("Equilateral");
            else if (a !== b && a !== c && b !== c) answer.push("Scalene");
            else answer.push("Isosceles");
        }
    });

    return answer.join("\n");
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

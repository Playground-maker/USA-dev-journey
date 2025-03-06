const readline = require("readline");

function solution(input) {
    let total = input.shift();
    let data = input.map((val) => val.split(" ").map(Number));
    let answer = [];

    for (let i = 0; i < data.length; i++) {
        let count = 1;
        for (let j = 0; j < data.length; j++) {
            if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) count++;
        }
        answer.push(count);
    }

    return answer.join(" ");
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

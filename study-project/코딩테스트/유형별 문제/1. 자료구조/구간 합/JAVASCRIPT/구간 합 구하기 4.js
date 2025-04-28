const readline = require("readline");

const solution = (input) => {
    const [total, count] = input.shift().split(" ").map(Number);
    const numbers = input.shift().split(" ").map(Number);
    const data = input.map((val) => val.split(" ").map(Number));

    let dp = [0];
    let answer = [];

    for (let i = 0; i < numbers.length; i++) {
        dp[i + 1] = dp[i] + numbers[i];
    }

    for (let i = 0; i < data.length; i++) {
        answer.push(dp[data[i][1]] - dp[data[i][0] - 1]);
    }

    return answer.join("\n");
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
        console.log(solution(input));
    });

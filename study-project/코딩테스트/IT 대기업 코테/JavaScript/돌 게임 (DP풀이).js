const readline = require("readline");

let dp = [0, 1, 2, 1, 2, 1];

const solution = (input) => {
    const game = (total) => {
        if (total > 5) {
            for (let i = 6; i <= total; i++) {
                if (dp[i - 1] === 1 && dp[i - 3] === 1) {
                    dp[i] = 2;
                } else {
                    dp[i] = 1;
                }
            }
        }
    };

    game(input);
    return dp[input] === 1 ? "SK" : "CY";
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

const readline = require("readline");

const solution = (input) => {
    const [size, count] = input.shift().split(" ").map(Number);
    const table = [];
    const data = [];
    let answer = [];

    for (let i = 0; i < size; i++) {
        table.push(input[i].split(" ").map(Number));
    }

    for (let i = size; i < input.length; i++) {
        data.push(input[i].split(" ").map(Number));
    }

    let dp = table.map((val) => [...val]);

    for (i = 0; i < size; i++) {
        for (j = 0; j < size; j++) {
            let sum = table[i][j];
            if (i !== 0) sum += dp[i - 1][j];
            if (j !== 0) sum += dp[i][j - 1];
            if (i !== 0 && j !== 0) sum -= dp[i - 1][j - 1];
            dp[i][j] = sum;
        }
    }

    data.forEach(([x1, y1, x2, y2]) => {
        [x1, y1, x2, y2] = [x1 - 1, y1 - 1, x2 - 1, y2 - 1];
        let sum = dp[x2][y2];
        if (x1 !== 0) sum -= dp[x1 - 1][y2];
        if (y1 !== 0) sum -= dp[x2][y1 - 1];
        if (x1 !== 0 && y1 !== 0) sum += dp[x1 - 1][y1 - 1];
        answer.push(sum);
    });

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

const readline = require("readline");

const solution = (input) => {
    let [, country] = input.shift().split(" ").map(Number);
    let data = input.map((val) => val.split(" ").map(Number)).map((val) => [val.shift(), val.join("")]);

    data.sort(([, val1], [, val2]) => val2 - val1);

    let rank = [[data[0], 1]];

    for (let i = 1; i < data.length; i++) {
        if (rank[i - 1][0][1] === data[i][1]) {
            rank.push([data[i], rank[i - 1][1]]);
        } else {
            rank.push([data[i], i + 1]);
        }
    }

    let answer = 0;

    for (let i = 0; i < rank.length; i++) {
        if (rank[i][0][0] === country) answer = rank[i][1];
    }

    return answer;
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

const readline = require("readline");

const solution = (input) => {
    const [n, record, p] = input.shift().split(" ").map(Number);
    if (n === 0) return 1;
    const scores = input[0].split(" ").map(Number);

    let rank = 0;
    let dup = 0;

    scores.forEach((val) => {
        if (val > record) rank++;
        if (val === record) dup++;
    });

    return n === p && rank + dup === n ? -1 : rank + 1;
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

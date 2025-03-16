const readline = require("readline");

const solution = (input) => {
    const [count, num] = input.shift().split(" ").map(Number);
    const table = input[0].split(" ").map(Number);

    let sum = 0;
    let dp = table.map((val) => (sum += val)); // 누적합
    let mod = dp.map((val) => val % num); // 누적합의 나머지

    let modSum = Array.from({ length: num }, () => 0);

    mod.forEach((val) => modSum[val]++); // 나머지가 같은 항목의 개수

    let answer = modSum[0];

    for (let i = 0; i < modSum.length; i++) {
        if (modSum[i] > 1) answer += (modSum[i] * (modSum[i] - 1)) / 2;
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

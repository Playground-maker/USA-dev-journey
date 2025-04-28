const readline = require("readline");

const solution = (input) => {
    let [total, num, data] = input.map((val, idx) => (idx === 2 ? val.split(" ").map(Number) : Number(val)));

    let countArr = [];
    let answer = 0;

    data.forEach((val) => {
        if (countArr[val]) countArr[val]++;
        else countArr[val] = 1;
    });

    let center = Math.ceil(num / 2);

    for (let i = 0; i < center; i++) {
        let front = countArr[i],
            rear = countArr[num - i];
        if (front !== undefined && rear !== undefined) {
            answer += front < rear ? front : rear;
        }
    }

    if (num % 2 === 0) {
        if (countArr[num / 2] > 1) {
            answer += Math.floor(countArr[num / 2] / 2);
        }
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

const readline = require("readline");

const solution = (input) => {
    let data = Number(input);

    let right = 1,
        left = 1,
        sum = 0,
        answer = 0;

    for (let i = right; i <= data; i++) {
        sum += i;

        while (sum >= data) {
            if (sum === data) answer++;
            sum -= left++;
        }
    }

    return answer;
};

readline
    .createInterface({
        input: process.stdin,
        output: process.stdout,
    })
    .on("line", (line) => {
        console.log(solution(line));
    });

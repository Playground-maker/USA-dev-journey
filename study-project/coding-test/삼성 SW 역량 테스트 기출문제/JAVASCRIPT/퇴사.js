const readline = require("readline");

function solution(input) {
    let days = Number(input.shift());
    let data = input.map((val) => val.split(" ").map(Number));
    let answer = 0;

    // 시행 가능한 경우를 마주할때 시행하거나 시행하지 않는 두 경우의 수를 고려해야한다.

    function work(nowday, cost, total) {
        for (let i = nowday; i < days; i++) {
            if (cost !== 0) {
                cost--;
                continue;
            }
            if (data[i][0] <= days - i) {
                work(i + 1, cost, total);
                cost = data[i][0] - 1;
                total += data[i][1];
            }
        }
        if (total > answer) answer = total;
    }

    work(0, 0, 0);
    return answer;
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

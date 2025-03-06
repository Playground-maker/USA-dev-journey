const readline = require("readline");

const solution = (input) => {
    let [, country] = input.shift().split(" ").map(Number);
    let data = input.map((val) => val.split(" ").map(Number));
    country--;

    data.sort(([a, , ,], [b, , ,]) => a - b);

    let answer = 1;

    for (let i = 0; i < data.length; i++) {
        if (data[country][1] < data[i][1]) {
            answer++;
        } else if (data[country][1] === data[i][1]) {
            if (data[country][2] < data[i][2]) {
                answer++;
            } else if (data[country][2] === data[i][2]) {
                if (data[country][3] < data[i][3]) {
                    answer++;
                }
            }
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

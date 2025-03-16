const readline = require("readline");

const solution = (input) => {
    const count = Number(input.shift());
    let data = input[0].split(" ").map(Number);
    if (count < 3) return 0;

    let answer = 0;

    data = data.sort((a, b) => a - b);

    for (let t = 0; t < count; t++) {
        let front = 0;
        let rear = count - 1;
        let target = data[t];
        let sum = 0;

        while (front < rear) {
            if (front === t) {
                front++;
                continue;
            }
            if (rear === t) {
                rear--;
                continue;
            }

            sum = data[front] + data[rear];
            if (sum === target) {
                answer++;
                break;
            } else if (sum > target) rear--;
            else if (sum < target) front++;
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

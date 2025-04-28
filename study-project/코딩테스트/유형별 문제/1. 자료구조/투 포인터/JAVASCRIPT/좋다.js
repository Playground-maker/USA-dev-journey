const readline = require("readline");

const solution = (input) => {
    const count = Number(input.shift());
    let data = input[0].split(" ").map(Number);
    if (count < 3) return 0;

    let answer = 0;

    data = data.sort((a, b) => a - b);

    for (let i = 0; i < count; i++) {
        let target = data[i];
        let rear = i === count - 1 ? count - 2 : count - 1;
        let sum = 0;

        for (let j = 0; j < count; j++) {
            if (i === j) continue;
            let front = data[j];
            sum = data[rear] + front;

            while (sum >= target) {
                if (sum === target) break;
                rear--;
                if (j === rear) break;
                if (rear !== i) sum = data[rear] + front;
            }
            if (j === rear) break;
            if (sum === target) {
                answer++;
                break;
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

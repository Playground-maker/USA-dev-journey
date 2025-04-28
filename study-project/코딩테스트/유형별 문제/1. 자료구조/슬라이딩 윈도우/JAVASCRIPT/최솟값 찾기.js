const readline = require("readline");

const solution = (input) => {
    const [N, L] = input.shift().split(" ").map(Number);
    const arr = input[0].split(" ").map(Number);

    if (L === 1) return arr.join(" ");

    const deque = new Array(N);
    let front = 0,
        back = 0;
    const result = [];

    for (let i = 0; i < N; i++) {
        if (front < back && deque[front] <= i - L) {
            front++;
        }
        while (front < back && arr[deque[back - 1]] > arr[i]) {
            back--;
        }
        deque[back++] = i;
        result.push(arr[deque[front]]);
    }

    return result.join(" ");
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

const readline = require("readline");

function solution(data) {
    const [n, ai, count] = data;
    const [...st] = ai.split(" ").map(Number);
    const [b, c] = count.split(" ").map(Number);
    let total = 0;

    for (let i = 0; i < Number(n); i++) {
        if (st[i] <= b) {
            total++;
            continue;
        }
        let nowSt = st[i] - b;
        let subTotal = Math.ceil(nowSt / c);
        total += subTotal + 1;
    }

    return total;
}

const input = [];
readline
    .createInterface({
        input: process.stdin,
    })
    .on("line", (line) => {
        input.push(line);
    })
    .on("close", () => {
        console.log(solution(input));
    });

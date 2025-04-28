const readline = require("readline");

function solution(input) {
    const [x, y, xArea, yArea] = input[0].split(" ").map(Number);

    let xres = Math.ceil(x / (xArea + 1));
    let yres = Math.ceil(y / (yArea + 1));

    return xres * yres;
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

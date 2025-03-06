const readline = require("readline");

function solution(input) {
    let data = input[0].toUpperCase().split("");
    let text = {};
    let answer = "";

    data.forEach((val) => {
        if (text[val]) {
            text[val]++;
        } else {
            text[val] = 1;
        }
    });

    let textArr = Object.entries(text).sort(([, a], [, b]) => b - a);
    if (textArr.length > 1 && textArr[0][1] === textArr[1][1]) {
        answer = "?";
    } else {
        answer = textArr[0][0];
    }

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

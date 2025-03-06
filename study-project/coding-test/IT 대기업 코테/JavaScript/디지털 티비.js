const readline = require("readline");

function solution(input) {
    input.shift();
    const channel = input;
    let remote = "";

    let kbs1Index = channel.indexOf("KBS1");

    for (let i = 0; i < kbs1Index; i++) {
        remote += "1";
    }

    for (let i = 0; i < kbs1Index; i++) {
        remote += "4";
        [channel[kbs1Index - i], channel[kbs1Index - i - 1]] = [channel[kbs1Index - i - 1], channel[kbs1Index - i]];
    }

    let kbs2Index = channel.indexOf("KBS2");

    for (let i = 0; i < kbs2Index; i++) {
        remote += "1";
    }
    for (let i = 0; i < kbs2Index - 1; i++) {
        remote += "4";
        [channel[kbs2Index - i], channel[kbs2Index - i - 1]] = [channel[kbs2Index - i - 1], channel[kbs2Index - i]];
    }

    return remote;
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

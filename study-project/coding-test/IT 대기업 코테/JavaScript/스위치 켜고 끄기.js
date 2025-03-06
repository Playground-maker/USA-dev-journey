const readline = require("readline");

const solution = (input) => {
    let [switchCount, switches, studentCount, ...data] = input.map((val) => val.split(" ").map(Number));
    let answer = "";
    switches.unshift(0);

    const man = (num) => {
        for (let i = num; i <= switchCount; i += num) {
            switches[i] = switches[i] ^ 1;
        }
    };

    const woman = (num) => {
        for (let i = 0; i < num; i++) {
            if (switches[num - i] === switches[num + i]) {
                let changeNum = switches[num - i] ^ 1;
                switches[num - i] = changeNum;
                switches[num + i] = changeNum;
            } else break;
        }
    };

    data.forEach(([gender, num]) => {
        gender === 1 ? man(num) : woman(num);
    });

    for (let i = 0; i < switches.length; i++) {
        if (i === 0) continue;
        answer += switches[i];
        i % 20 === 0 ? (answer += "\n") : (answer += " ");
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

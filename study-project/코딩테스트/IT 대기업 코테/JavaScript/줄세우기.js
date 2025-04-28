const readline = require("readline");

const solution = (input) => {
    let total = input.shift();
    let data = [];
    let answer = [];
    input.forEach((val) => {
        let nowValue = val.split(" ");
        nowValue.shift();
        data.push(nowValue.map(Number));
    });

    const sort = (data) => {
        let arr = [];
        let total = 0;
        data.forEach((val) => {
            let count = -1; // 2
            for (let i = 0; i < arr.length; i++) {
                if (arr[i] > val) {
                    // i = 2
                    count = i;
                    break;
                }
            }
            if (count !== -1) {
                for (let i = arr.length - 1; i >= count; i--) {
                    arr[i + 1] = arr[i];
                    total++;
                }
                arr[count] = val;
            } else arr.push(val);
        });
        return total;
    };

    data.forEach((val, idx) => {
        answer.push(`${idx + 1} ${sort(val)}`);
    });

    return answer.join("\n");
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

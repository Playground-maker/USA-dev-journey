const readline = require("readline");

const solution = (input) => {
    const [n, ...data] = input;

    let head = [0, 0]; // 머리 좌표

    for (let i = 0; i < n; i++) {
        let tmp = false;
        for (let j = 0; j < n; j++) {
            if (data[i][j] === "*") {
                head = [i, j];
                tmp = true;
                break;
            }
        }
        if (tmp === true) break;
    }

    let armLength = 0; // 팔 전체 길이
    let armRow = head[0] + 1; // 팔의 행
    let firstArmPos = [0, 0]; // 팔의 좌측 끝 좌표

    for (let i = 0; i < n; i++) {
        if (data[armRow][i] === "*") {
            if (armLength === 0) firstArmPos = [armRow, i];
            armLength++;
        }
    }

    let leftLegSearchPoint = [firstArmPos[0] + 1, head[1] - 1];
    let leftLegPos = [0, 0]; // 왼쪽 다리 최상단 좌표

    for (let i = leftLegSearchPoint[0]; i < n; i++) {
        if (data[i][leftLegSearchPoint[1]] === "*") {
            leftLegPos = [i, leftLegSearchPoint[1]];
            break;
        }
    }

    let leftLegLength = 0; // 왼쪽 다리 길이
    let rightLegLength = 0; // 오른쪽 다리 길이

    for (let i = leftLegPos[0]; i < n; i++) {
        if (data[i][leftLegPos[1]] === "*") leftLegLength++;
        if (data[i][leftLegPos[1] + 2] === "*") rightLegLength++;
    }

    let leftArmLength = head[1] - firstArmPos[1];
    let rightArmLength = armLength - leftArmLength - 1;
    let waistLength = leftLegPos[0] - firstArmPos[0] - 1;

    let answer = [
        [head[0] + 2, head[1] + 1],
        [leftArmLength, rightArmLength, waistLength, leftLegLength, rightLegLength],
    ];

    return answer.map((val) => val.join(" ")).join("\n");
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

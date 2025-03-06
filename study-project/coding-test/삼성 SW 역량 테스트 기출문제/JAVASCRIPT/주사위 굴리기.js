const readline = require("readline");

function solution(input) {
    let firstData = input.shift();
    firstData = firstData.split(" ");

    const [mapx, mapy] = [Number(firstData[0]), Number(firstData[1])];
    const diceFirstPos = [Number(firstData[2]), Number(firstData[3])];

    let moveData = input.pop();
    moveData = moveData.split(" ").map(Number);

    let mapData = input.map((val) => val.split(" ").map(Number));

    let d = [0, 0, 0, 0, 0, 0];
    let [nowx, nowy] = [...diceFirstPos];
    let answer = [];

    function moveDice(dir) {
        switch (dir) {
            case 1:
                d = [d[2], d[1], d[5], d[0], d[4], d[3]];
                break;
            case 2:
                d = [d[3], d[1], d[0], d[5], d[4], d[2]];
                break;
            case 3:
                d = [d[1], d[5], d[2], d[3], d[0], d[4]];
                break;
            case 4:
                d = [d[4], d[0], d[2], d[3], d[5], d[1]];
                break;
        }
    }

    function movePos(dir) {
        let [nextx, nexty] = [nowx, nowy];
        switch (dir) {
            case 1:
                nexty = nexty + 1;
                break;
            case 2:
                nexty = nexty - 1;
                break;
            case 3:
                nextx = nextx - 1;
                break;
            case 4:
                nextx = nextx + 1;
                break;
        }
        return [nextx, nexty];
    }

    moveData.forEach((val) => {
        let [nextx, nexty] = movePos(val);
        if (nextx < mapx && nexty < mapy && nextx >= 0 && nexty >= 0) {
            nowx = nextx;
            nowy = nexty;
            moveDice(val);

            if (mapData[nowx][nowy] === 0) {
                mapData[nowx][nowy] = d[0];
            } else {
                d[0] = mapData[nowx][nowy];
                mapData[nowx][nowy] = 0;
            }
            answer.push(d[5]);
        }
    });
    return answer.join("\n");
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

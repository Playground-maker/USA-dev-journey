const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];
rl.on("line", (line) => {
    input.push(line);
});
rl.on("close", () => {
    const [M, S] = input[0].split(" ").map(Number);
    let fishGrid = Array.from({ length: 4 }, () => Array.from({ length: 4 }, () => []));
    for (let i = 1; i <= M; i++) {
        const [fx, fy, d] = input[i].split(" ").map(Number);
        fishGrid[fx - 1][fy - 1].push(d);
    }
    let [sharkX, sharkY] = input[M + 1].split(" ").map(Number);
    sharkX--;
    sharkY--;

    // 물고기 냄새 배열, 0이면 냄새가 없고 냄새가 있을경우 냄새가 생성된 라운드 번호
    let smell = Array.from({ length: 4 }, () => Array(4).fill(0));

    // 물고기 방향 배열
    const fishDirs = [null, [0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]];

    // 상어 방향 배열
    const sharkDirs = [
        [-1, 0],
        [0, -1],
        [1, 0],
        [0, 1],
    ];

    let bestCount, bestPath;

    // 사전순 경로 비교
    function isLexSmaller(a, b) {
        for (let i = 0; i < 3; i++) {
            if (a[i] < b[i]) return true;
            else if (a[i] > b[i]) return false;
        }
        return false;
    }

    // DFS로 상어 3칸 이동 경로 찾기
    function dfs(x, y, depth, path, count, visited) {
        if (depth === 3) {
            if (count > bestCount) {
                bestCount = count;
                bestPath = path.slice();
            } else if (count === bestCount) {
                if (isLexSmaller(path, bestPath)) bestPath = path.slice();
            }
            return;
        }
        for (let i = 0; i < 4; i++) {
            const nx = x + sharkDirs[i][0];
            const ny = y + sharkDirs[i][1];
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
            let add = 0;
            let flag = false;
            if (!visited[nx][ny]) {
                flag = true;
                add = fishGrid[nx][ny].length;
                visited[nx][ny] = true;
            }
            path.push(i + 1);
            dfs(nx, ny, depth + 1, path, count + add, visited);
            path.pop();
            if (flag) visited[nx][ny] = false;
        }
    }

    // 연습 진행 반복문
    for (let round = 1; round <= S; round++) {
        // 복제 마법을 진행하기 전 현재 물고기 위치 복사
        const copyFish = Array.from({ length: 4 }, (_, i) =>
            Array.from({ length: 4 }, (_, j) => fishGrid[i][j].slice())
        );

        // 모든 물고기를 방향에 맞춰 이동
        let newFishGrid = Array.from({ length: 4 }, () => Array.from({ length: 4 }, () => []));
        for (let i = 0; i < 4; i++) {
            for (let j = 0; j < 4; j++) {
                for (let d of fishGrid[i][j]) {
                    let nd = d,
                        moved = false;
                    for (let k = 0; k < 8; k++) {
                        const [dx, dy] = fishDirs[nd];
                        const nx = i + dx,
                            ny = j + dy;
                        if (
                            nx >= 0 &&
                            nx < 4 &&
                            ny >= 0 &&
                            ny < 4 &&
                            !(nx === sharkX && ny === sharkY) &&
                            smell[nx][ny] === 0
                        ) {
                            newFishGrid[nx][ny].push(nd);
                            moved = true;
                            break;
                        }
                        nd = nd - 1;
                        if (nd === 0) nd = 8;
                    }
                    if (!moved) newFishGrid[i][j].push(d);
                }
            }
        }
        fishGrid = newFishGrid;

        // 상어 이동
        bestCount = -1;
        bestPath = [0, 0, 0];
        const visited = Array.from({ length: 4 }, () => Array(4).fill(false));
        dfs(sharkX, sharkY, 0, [], 0, visited);
        let nx = sharkX,
            ny = sharkY;
        for (let move of bestPath) {
            const dir = sharkDirs[move - 1];
            nx += dir[0];
            ny += dir[1];
            // 이동 경로에 물고기가 있으면 물고기 배열을 비우고 물고기 냄새 배열에 라운드수 추가
            if (fishGrid[nx][ny].length > 0) {
                fishGrid[nx][ny] = [];
                smell[nx][ny] = round;
            }
        }
        sharkX = nx;
        sharkY = ny;

        // 두 라운드 전 냄새 제거
        for (let i = 0; i < 4; i++) {
            for (let j = 0; j < 4; j++) {
                if (smell[i][j] !== 0 && round - smell[i][j] >= 2) {
                    smell[i][j] = 0;
                }
            }
        }

        // 물고기 이동전 복사해둔 배열과 이동 완료한 배열을 합쳐 완료
        for (let i = 0; i < 4; i++) {
            for (let j = 0; j < 4; j++) {
                fishGrid[i][j] = fishGrid[i][j].concat(copyFish[i][j]);
            }
        }
    }

    // 최종 물고기 수 세기
    let ans = 0;
    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            ans += fishGrid[i][j].length;
        }
    }
    console.log(ans);
});

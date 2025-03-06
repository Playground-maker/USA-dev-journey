const fs = require("fs");
const stdin = fs.readFileSync("/dev/stdin").toString().split("\n");
const input = (() => {
    let line = 0;
    const input = () => stdin[line++];
    input.num = () => input().split(" ").map(Number);
    input.rows = (l) => Array(l).fill().map(input);
    input.rows.num = (l) => Array(l).fill().map(input.num);
    return input;
})();

// 행렬을 변환하는 함수들
const transpose = (arr) => arr[0].map((_, i) => arr.map((row) => row[i])); // 행렬을 전치(행과 열 바꾸기)
const reverseUD = (arr) => [...arr].reverse(); // 상하 반전
const reverseLR = (arr) => arr.map((row) => row.reverse()); // 좌우 반전
const rotateCW = (arr) => reverseLR(transpose(arr)); // 시계 방향 90도 회전
const sum = (arr) => arr.reduce((a, b) => a + b, 0); // 배열의 합 계산
const maxBowlValue = (bowls) => Math.max(...bowls.flat()); // 최대 어항값
const minBowlValue = (bowls) => Math.min(...bowls.flat()); // 최소 어항값

// 떨어뜨렸던 어항들 다시 병합하는 함수
const zip = (arr, concatable) => {
    const getConcatableRow = (index) => (index < concatable.length ? concatable[index] : []);
    return arr.map((row, i) => [...row, ...getConcatableRow(i)]);
};

// 물고기수가 적은곳에 물고기 추가
// 모든곳 추가를 위해 값비교를 사용
const addFish = (bowls) => {
    const min = minBowlValue(bowls);
    return bowls.map((row) => row.map((v) => (v === min ? v + 1 : v)));
};

// 물고기 분배
const distribute = (bowls) => {
    const dir = [
        [0, 1],
        [1, 0],
        [0, -1],
        [-1, 0],
    ];
    const getNeighbors = (x, y) => dir.map((d) => [x + d[0], y + d[1]]);
    const calcDelta = (a, b) => {
        if (typeof a !== "number" || typeof b !== "number") return 0;
        const delta = Math.floor(Math.abs(a - b) / 5);
        return a < b ? delta : -delta;
    };
    const getBowlValue = (x, y) => {
        if (x < 0 || y < 0 || bowls[x] === undefined) return undefined;
        return bowls[x][y];
    };

    const deltas = bowls.map((row, x) =>
        row.map((value, y) => sum(getNeighbors(x, y).map(([nx, ny]) => calcDelta(value, getBowlValue(nx, ny)))))
    );

    return bowls.map((row, i) => row.map((value, j) => value + deltas[i][j]));
};

// 어항을 한 번 쌓아 올리는 함수
const rollOnce = (bowls, size) => zip(bowls.slice(size), rotateCW(bowls.slice(0, size)));

// 가능할때까지 어항을 쌓는 함수
const roll = (bowls) => {
    const rollSize = bowls.filter((row) => row.length > 1).length || 1;
    const height = bowls[0].length;
    if (rollSize + height > bowls.length) return bowls;
    return roll(rollOnce(bowls, rollSize));
};

// 어항 반으로 접기
const fold = (bowls) => zip(bowls.slice(bowls.length / 2), reverseLR(reverseUD(bowls.slice(0, bowls.length / 2))));
const flat = (bowls) => bowls.flat().map((v) => [v]); // 2차원 배열을 1차원으로 변환

// 종료 조건 확인: 최대 최소 차이가 k 이하인지 확인
const canFinish = (bowls, k) => maxBowlValue(bowls) - minBowlValue(bowls) <= k;

const solution = function () {
    const [n, k] = input.num();
    let bowls = input.num().map((v) => [v]);

    let ans = 0;
    while (!canFinish(bowls, k)) {
        bowls = addFish(bowls);
        bowls = roll(bowls);
        bowls = distribute(bowls);
        bowls = flat(bowls);
        bowls = fold(bowls);
        bowls = fold(bowls);
        bowls = distribute(bowls);
        bowls = flat(bowls);
        ans++;
    }
    console.log(ans);
};

solution();

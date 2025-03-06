function solution(rectangle, characterX, characterY, itemX, itemY) {
    let map = Array.from({ length: 102 }, (val) => val.map(() => Array(102).fill(0)));
    console.log(map[0]);
}

console.log(
    solution(
        [
            [1, 1, 7, 4],
            [3, 2, 5, 5],
            [4, 3, 6, 9],
            [2, 6, 8, 8],
        ],
        1,
        3,
        7,
        8
    )
);

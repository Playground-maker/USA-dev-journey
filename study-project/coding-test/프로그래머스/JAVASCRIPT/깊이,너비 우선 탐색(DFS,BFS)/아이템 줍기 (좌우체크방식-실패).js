let arr = Array(6)
    .fill(0)
    .map(() => Array(6).fill(0));

arr[2][3] = [
    [0, 0],
    [0, 1],
];

function solution(rectangle, characterX, characterY, itemX, itemY) {
    // 상/좌/하 , 하/우/상 순서로 경로 검토 = 2개의 경로가 나옴 = 둘중 짧은걸 반환

    let direction = [[1,0],[0,1],[-1,0],[0,-1]];
    
    function 

    var answer = 0;
    return answer;
}

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
);

console.log(arr);

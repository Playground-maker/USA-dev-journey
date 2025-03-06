const readline = require("readline");

const solution = (data) => {
    // 보드는 2차원 배열로 저장, 빈칸은 0으로 사과는 1로 저장.
    // 방향 전환 내용은 key-value 형태로 객체에 저장.
    // 이동방향 배열을 두어 nowDir 변수에 현재 이동방향에 따른 인덱스를 저장. 이후 D 혹은 L에 따라 nowDir을 조정.
    // 뱀의 머리의 좌표가 배열 사이즈를 벗어남 || 음수 || 몸통의 좌표와 겹칠 경우 게임이 종료.
    // 뱀의 머리에 사과가 없을경우 shift (queue)
    // ! 사과를 먹은경우 0으로 변경해야함 <= 이거때문에 한번 틀림

    let boardSize = Number(data.split("\n")[0]);
    let board = Array.from({ length: boardSize }, () => Array(boardSize).fill(0));
    let appleSize = Number(data.split("\n")[1]);
    let apple = data.split("\n").slice(2, 2 + appleSize);

    apple.forEach((val) => {
        let [x, y] = val.split(" ");
        board[Number(x) - 1][Number(y) - 1] = 1;
    });

    let changeDir = data
        .split("\n")
        .slice(3 + appleSize)
        .reduce((acc, line) => {
            const [key, value] = line.split(" ");
            acc[key] = value;
            return acc;
        }, {});

    let direction = [
        [0, 1],
        [1, 0],
        [0, -1],
        [-1, 0],
    ];
    let nowDir = 0;
    let snake = [[0, 0]];
    let time = 0;

    const isWall = (head) => {
        if (head[0] >= boardSize || head[1] >= boardSize) return true;
        if (head[0] < 0 || head[1] < 0) return true;
        return false;
    };

    const isSelf = (head) => {
        return snake.some((val) => val[0] === head[0] && val[1] === head[1]);
    };

    const isApple = (head) => {
        if (board[head[0]][head[1]] === 1) {
            board[head[0]][head[1]] = 0;
            return true;
        }
        return false;
    };

    const move = (head) => {
        if (time in changeDir) {
            if (changeDir[time] === "D") {
                if (nowDir === 3) nowDir = 0;
                else nowDir++;
            } else if (changeDir[time] === "L") {
                if (nowDir === 0) nowDir = 3;
                else nowDir--;
            }
        }
        let [x, y] = head;
        return [x + direction[nowDir][0], y + direction[nowDir][1]];
    };

    while (1) {
        let nowHead = snake[snake.length - 1]; // 현재 머리 위치
        let newHead = move(nowHead); // 다음 머리 위치 계산
        time++; // 머리위치 계산 후 시간 더하기
        if (isWall(newHead) || isSelf(newHead)) break; // 다음 머리 위치가 벽이거나 자신의 몸통일경우 반복문 종료
        if (isApple(newHead) === false) snake.shift(); // 다음 머리 위치에 사과가 없으면 unshift (배열 첫째항목 제거)
        snake.push(newHead); // 다음 머리 위치 배열에 추가
    }

    return time;
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
        const data = input.join("\n");
        console.log(solution(data));
    });

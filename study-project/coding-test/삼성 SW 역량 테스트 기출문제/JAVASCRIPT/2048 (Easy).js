function solution(input) {
    const lines = input.trim().split("\n"); // 줄 단위로 나누기
    const N = Number(lines[0]); // 첫 번째 줄에서 보드 크기 N 추출
    const boardInput = lines.slice(1).map((line) => line.split(" ").map(Number)); // 보드 데이터 추출

    const directions = [
        [0, -1], // 위
        [0, 1], // 아래
        [-1, 0], // 왼쪽
        [1, 0], // 오른쪽
    ];

    let maxBlock = 0;

    const copyBoard = (board) => board.map((row) => [...row]);

    const getMaxBlock = (board) => Math.max(...board.flat());

    const move = (board, direction) => {
        const [dx, dy] = direction;
        let merged = Array.from({ length: N }, () => Array(N).fill(false));
        let newBoard = copyBoard(board);

        const range = [...Array(N).keys()];
        if (dx === 1 || dy === 1) range.reverse();

        for (const x of range) {
            for (const y of range) {
                if (newBoard[x][y] === 0) continue;

                let nx = x,
                    ny = y;
                while (true) {
                    const nxNext = nx + dx,
                        nyNext = ny + dy;

                    if (nxNext < 0 || nxNext >= N || nyNext < 0 || nyNext >= N) break;
                    if (newBoard[nxNext][nyNext] !== 0 && newBoard[nxNext][nyNext] !== newBoard[x][y]) break;

                    if (newBoard[nxNext][nyNext] === newBoard[x][y] && !merged[nxNext][nyNext]) {
                        newBoard[nxNext][nyNext] *= 2;
                        newBoard[nx][ny] = 0;
                        merged[nxNext][nyNext] = true;
                        break;
                    }

                    if (newBoard[nxNext][nyNext] === 0) {
                        newBoard[nxNext][nyNext] = newBoard[nx][ny];
                        newBoard[nx][ny] = 0;
                        nx = nxNext;
                        ny = nyNext;
                    }
                }
            }
        }

        return newBoard;
    };

    const dfs = (board, depth) => {
        if (depth === 5) {
            maxBlock = Math.max(maxBlock, getMaxBlock(board));
            return;
        }

        for (const dir of directions) {
            const newBoard = move(board, dir);
            dfs(newBoard, depth + 1);
        }
    };

    dfs(copyBoard(boardInput), 0);

    return maxBlock;
}

// 테스트
const input = `3
2 2 2
4 4 4
8 8 8`;

console.log(solution(input)); // 출력: 16

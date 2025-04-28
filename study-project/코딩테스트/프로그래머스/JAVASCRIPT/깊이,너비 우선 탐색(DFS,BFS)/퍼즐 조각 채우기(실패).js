function solution(game_board, table) {
    let blocks = [];
    let emptySpace = [];
    let blockQueue = [];
    let visited = table.map((row) => row.map(() => false));

    let blockSearchArr = [
        [-1, 0],
        [0, -1],
        [1, 0],
        [0, 1],
    ];

    function rotateBlock([...arr]) {
        let newArr = arr.map(([val1, val2]) => {
            let newX = -val2;
            let newY = val1;
            if (newX === -0) newX = 0;
            let move = [newX, newY];
            return move;
        });
        return newArr;
    }

    function blockReOrder([...arr]) {
        let dx = arr[0][0];
        let dy = arr[0][1];
        let newArr = arr.map(([x, y]) => {
            let newX = x - dx;
            let newY = y - dy;
            return [newX, newY];
        });
        return newArr;
    }

    function arraysAreEqual(arr1, arr2) {
        let count = 0;
        if (arr1.length !== arr2.length) return false;
        for (let i = 0; i < arr2.length; i++) {
            let [dx, dy] = arr2[i];
            let newBlock = arr2.map(([x, y]) => [x - dx, y - dy]);
            let sortedBlock = blockBfs(newBlock, i);
            for (let i = 0; i < arr1.length; i++) {
                if (arr1[i][0] !== sortedBlock[i][0] || arr1[i][1] !== sortedBlock[i][1]) break;
                else {
                    count++;
                }
            }
            if (count === arr1.length) {
                count = 0;
                return true;
            }
            count = 0;
        }
        return false;
    }

    const blockBfs = ([...arr], first) => {
        let visited = Array(arr.length).fill(false);
        let queue = [arr[first]];
        visited[first] = true;
        let newArr = [arr[first]];
        while (queue.length !== 0) {
            let [x, y] = queue[0];
            queue.shift();
            blockSearchArr.forEach(([dx, dy]) => {
                let newX = x + dx;
                let newY = y + dy;
                arr.forEach((val, idx) => {
                    if (val[0] === newX && val[1] === newY && visited[idx] === false) {
                        queue.push(val);
                        newArr.push(val);
                        visited[idx] = true;
                    }
                });
            });
        }
        return newArr;
    };

    const bfs = (table, blockSpace, result) => {
        for (let i = 0; i < table.length; i++) {
            for (let j = 0; j < table.length; j++) {
                if (table[i][j] === blockSpace && visited[i][j] === false) {
                    blockQueue.push([i, j]);
                    visited[i][j] = true;
                    let nowBlock = [[i, j]];
                    while (blockQueue.length !== 0) {
                        let [x, y] = blockQueue[0];
                        blockQueue.shift();
                        blockSearchArr.forEach(([dx, dy]) => {
                            let newX = x + dx;
                            let newY = y + dy;
                            if (newX >= table.length || newY >= table.length || newX < 0 || newY < 0) return;
                            else if (table[x + dx][y + dy] === blockSpace && visited[x + dx][y + dy] === false) {
                                blockQueue.push([x + dx, y + dy]);
                                nowBlock.push([x + dx, y + dy]);
                                visited[x + dx][y + dy] = true;
                            }
                        });
                    }
                    result.push(blockReOrder(nowBlock));
                }
            }
        }
        visited = table.map((row) => row.map(() => false));
    };

    bfs([...table], 1, blocks);
    bfs([...game_board], 0, emptySpace);

    let compBlock = [];
    let answer = 0;

    for (let i = 0; i < emptySpace.length; i++) {
        let space = emptySpace[i];
        for (let j = 0; j < blocks.length; j++) {
            let block = blocks[j];
            if (space !== null && block !== null && space.length === block.length) {
                if (arraysAreEqual(space, block)) {
                    answer += block.length;
                    emptySpace[i] = null;
                    blocks[j] = null;
                    break;
                }
                for (let i = 0; i < 3; i++) {
                    if (compBlock.length === 0) compBlock = block;
                    compBlock = rotateBlock(compBlock);
                    if (arraysAreEqual(space, compBlock)) {
                        answer += block.length;
                        emptySpace[i] = null;
                        blocks[j] = null;
                        break;
                    }
                }
                compBlock = [];
            }
        }
    }

    return answer;
}

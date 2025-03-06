function solution(N, number) {
    let data = Array(9)
        .fill(null)
        .map(() => new Set());
    if (N === number) {
        return 1;
    } else {
        data.forEach((val, idx) => {
            if (idx !== 0) val.add(Number(String(N).repeat(idx)));
        });
        for (let i = 1; i < 9; i++) {
            for (let j = 1; j < i; j++) {
                data[j].forEach((val1, idx1) => {
                    data[i - j].forEach((val2, idx2) => {
                        data[i].add(val1 + val2);
                        data[i].add(val1 - val2);
                        data[i].add(val1 * val2);
                        data[i].add(val1 / val2);
                    });
                });
            }
            if (data[i].has(number)) return i;
        }
        return -1;
    }
}

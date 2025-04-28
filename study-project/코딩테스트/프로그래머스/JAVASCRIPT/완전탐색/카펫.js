function solution(brown, yellow) {
    let total = brown + yellow;
    let div = [];
    let b = 0,
        y = 0;
    let answer = [];

    for (let i = 1; i <= Math.sqrt(total); i++) {
        if (total % i === 0) {
            div.push([i, total / i]);
        }
    }

    div.forEach((val, idx) => {
        if (val[0] === 1 || val[0] === 2) b = val[0] * val[1];
        else {
            b = val[1] * 2;
            b += (val[0] - 2) * 2;
            y = val[0] * val[1] - b;
        }
        if (brown === b && yellow === y) {
            answer.push(val[1]);
            answer.push(val[0]);
        }
    });

    return answer;
}

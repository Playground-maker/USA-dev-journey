function solution(begin, target, words) {
    begin = begin.split("");
    target = target.split("");
    words = words.map((val) => val.split(""));
    let visited = Array(words.length).fill(false);
    let answer = 99;

    function arrayComp(a, b) {
        if (JSON.stringify(a) === JSON.stringify(b)) {
            return true;
        }
        return false;
    }

    function dfs(nowWord, depth) {
        if (arrayComp(nowWord, target)) {
            if (depth < answer) answer = depth;
        }
        words.forEach((val, idx) => {
            if (visited[idx] === false) {
                let count = 0;
                val.forEach((nowAlph, alphIdx) => {
                    if (nowAlph !== nowWord[alphIdx]) count++;
                });
                if (count === 1) {
                    depth = depth + 1;
                    visited[idx] = true;
                    dfs(val, depth);
                    depth = depth - 1;
                    visited[idx] = false;
                }
            }
        });
    }

    dfs(begin, 0);
    if (answer === 99) return 0;
    return answer;
}

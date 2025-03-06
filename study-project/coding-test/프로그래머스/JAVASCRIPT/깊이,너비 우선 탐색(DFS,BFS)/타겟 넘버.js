function solution(numbers, target) {
    let answer = 0;

    function calc(total, depth) {
        if (depth === numbers.length) {
            if (total === target) {
                answer++;
            }
            return;
        }
        calc(total + numbers[depth], depth + 1);
        calc(total - numbers[depth], depth + 1);
    }

    calc(0, 0);
    return answer;
}

function solution(word) {
    const cha = ["A", "E", "I", "O", "U"];
    const dictionary = [];

    for (let i = 0; i < 5; i++) {
        dictionary.push(cha[i]);
        for (let j = 0; j < 5; j++) {
            dictionary.push(cha[i] + cha[j]);
            for (let k = 0; k < 5; k++) {
                dictionary.push(cha[i] + cha[j] + cha[k]);
                for (let l = 0; l < 5; l++) {
                    dictionary.push(cha[i] + cha[j] + cha[k] + cha[l]);
                    for (let m = 0; m < 5; m++) {
                        dictionary.push(cha[i] + cha[j] + cha[k] + cha[l] + cha[m]);
                    }
                }
            }
        }
    }

    return dictionary.indexOf(word) + 1;
}

// 테스트 예제
console.log(solution("A")); // 1
console.log(solution("AA")); // 2
console.log(solution("EIO")); // 1189

const readline = require("readline");

const solution = (input) => {
    const [dnaSize, slice] = input.shift().split(" ").map(Number);
    const dna = input.shift().split("");
    const [minA, minC, minG, minT] = input[0].split(" ").map(Number);

    let keyword = { A: 0, C: 0, G: 0, T: 0 };

    let answer = 0;

    const isValidPassword = () => {
        if (keyword.A >= minA && keyword.C >= minC && keyword.G >= minG && keyword.T >= minT) answer++;
    };

    for (let i = 0; i < slice; i++) {
        keyword[dna[i]]++;
    }
    isValidPassword();

    for (let j = slice; j < dnaSize; j++) {
        keyword[dna[j]]++;
        keyword[dna[j - slice]]--;
        isValidPassword();
    }

    return answer;
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
        console.log(solution(input));
    });

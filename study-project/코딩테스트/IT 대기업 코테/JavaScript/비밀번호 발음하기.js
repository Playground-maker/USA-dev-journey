const readline = require("readline");

const solution = (data) => {
    data.pop();
    let answer = [];

    const isVowel = (val) => {
        if (val === "a" || val === "e" || val === "i" || val === "o" || val === "u") return true;
        else return false;
    };

    data.forEach((val) => {
        let vowel = 0;
        let dup = 1;
        let isPrevVowel = isVowel(val[0]);
        let prevLetter = val[0];
        let isValid = true;

        for (let i = 0; i < val.length; i++) {
            let letter = val[i];
            let isNowLetterVowel = isVowel(letter);

            if (isNowLetterVowel) vowel++;
            if (i === 0) continue;

            if (isNowLetterVowel === isPrevVowel) {
                dup++;
                if (dup === 3) {
                    isValid = false;
                    break;
                }
            } else {
                dup = 1;
                isPrevVowel = isNowLetterVowel;
            }

            if (letter === prevLetter) {
                if (letter !== "e" && letter !== "o") {
                    isValid = false;
                    break;
                }
            }
            prevLetter = letter;
        }

        if (isValid === false || vowel === 0) answer.push(`<${val}> is not acceptable.`);
        else answer.push(`<${val}> is acceptable.`);
    });

    return answer.join("\n");
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

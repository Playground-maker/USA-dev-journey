import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            if (isAcceptable(str)) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }
        }
    }

    private static boolean isAcceptable(String str) {
        boolean hasVowel = false;
        int vowelCount = 0, consonantCount = 0;
        char prevChar = '\0';

        for (char c : str.toCharArray()) {
            // 모음 가지고 있는지 확인
            if (isVowel(c)) {
                hasVowel = true;
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            // 모음 or 자음 연속 3개 가지고 있는지 확인
            if (vowelCount == 3 || consonantCount == 3) {
                return false;
            }

            // 같은 글자 2개 연속인지 확인 / ee랑 oo는 제외
            if (c == prevChar && c != 'e' && c != 'o') {
                return false;
            }

            // 같은 글자 확인 위해서 갱신
            prevChar = c;
        }

        return hasVowel;
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}

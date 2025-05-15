import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alpha = new int[26];

        // 알파벳 개수 세기
        for (char c : word.toCharArray()) {
            alpha[c - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                oddCount++;
                oddIndex = i;
            }
        }

        // 회문은 홀수 개의 문자가 1개 이하일 때만 가능
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();

        // 앞부분과 뒷부분 만들기
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                front.append((char) (i + 'A'));
            }
        }

        // back은 front의 reverse
        back.append(front).reverse();

        // 홀수 개 문자가 있다면 가운데에 추가
        if (oddIndex != -1) {
            front.append((char) (oddIndex + 'A'));
        }

        // 정답 출력
        System.out.println(front.toString() + back.toString());
    }
}
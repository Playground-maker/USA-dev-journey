import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine(); // 목표 문자열
        int idx = 0;  // target 문자열에서 현재 비교 중인 문자 인덱스
        int num = 1;  // 1부터 자연수 증가

        // target의 모든 문자를 찾을 때까지 반복
        while (idx < target.length()) {
            String current = String.valueOf(num);  // 현재 자연수를 문자열로 변환

            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == target.charAt(idx)) {
                    idx++;  // 일치하면 다음 문자로 이동

                    if (idx == target.length()) {
                        break;  // 모든 문자를 찾았으면 종료
                    }
                }
            }

            num++;  // 다음 자연수로 이동
        }

        // 마지막에 num이 한 번 더 증가했으므로 -1
        System.out.println(num - 1);
    }
}
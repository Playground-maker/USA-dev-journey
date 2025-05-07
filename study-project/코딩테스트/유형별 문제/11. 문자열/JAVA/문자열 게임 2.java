import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;

            // 각 문자별 인덱스를 저장할 리스트
            ArrayList<Integer>[] pos = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                pos[i] = new ArrayList<>();
            }

            // 인덱스 저장
            for (int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                pos[c - 'a'].add(i);
            }

            for (int i = 0; i < 26; i++) {
                if (pos[i].size() < K) continue;

                // K개 연속된 인덱스를 잡아서 길이 계산
                for (int j = 0; j <= pos[i].size() - K; j++) {
                    int start = pos[i].get(j);
                    int end = pos[i].get(j + K - 1);
                    int length = end - start + 1;

                    minLen = Math.min(minLen, length);
                    maxLen = Math.max(maxLen, length);
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}
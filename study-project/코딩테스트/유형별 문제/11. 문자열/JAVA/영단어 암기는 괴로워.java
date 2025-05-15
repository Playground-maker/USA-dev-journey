import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        // 단어 입력 및 조건에 따라 Map에 저장
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Map의 keySet을 리스트로 변환 후 정렬
        List<String> words = new ArrayList<>(map.keySet());

        // 정렬 조건에 따라 정렬
        Collections.sort(words, (w1, w2) -> {
            int freq1 = map.get(w1);
            int freq2 = map.get(w2);

            if (freq1 != freq2) {
                return freq2 - freq1; // 빈도 내림차순
            } else if (w1.length() != w2.length()) {
                return w2.length() - w1.length(); // 길이 내림차순
            } else {
                return w1.compareTo(w2); // 사전순 오름차순
            }
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }
}
// 숫자(문자열) 압축
// 573784, 7848223 => 5737848223
// 1234, 3456, 23456 => 123456
// 4124, 41245 => 41245

import java.util.*;

class Solution {
    public String solution(String[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        String answer = null;

        // 모든 순열을 돌면서 가장 작은 결과 문자열 찾기
        answer = dfs("", arr, visited, 0, null);

        return answer;
    }

    private String dfs(String current, String[] arr, boolean[] visited, int depth, String min) {
        if (depth == arr.length) {
            if (min == null || current.compareTo(min) < 0) {
                return current;
            }
            return min;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String merged = merge(current, arr[i]);
                min = dfs(merged, arr, visited, depth + 1, min);
                visited[i] = false;
            }
        }

        return min;
    }

    // 두 문자열을 겹치는 부분을 최대한 활용해 병합
    private String merge(String a, String b) {
        if (a.isEmpty()) return b;

        int maxOverlap = 0;
        int minLen = Math.min(a.length(), b.length());

        for (int i = 1; i <= minLen; i++) {
            if (a.substring(a.length() - i).equals(b.substring(0, i))) {
                maxOverlap = i;
            }
        }

        return a + b.substring(maxOverlap);
    }
}
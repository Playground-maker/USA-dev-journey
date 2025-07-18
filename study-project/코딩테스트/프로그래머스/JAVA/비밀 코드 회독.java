import java.util.*;

class Solution {

    static int N;
    static int[] ANSWER;
    static int[][] Q;

    static int answer = 0;
    static List<Integer> list = new ArrayList<>();

    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        ANSWER = ans;
        Q = q;

        dfs(1, 0);
        return answer;
    }

    private static void dfs(int current, int count) {
        if(count == 5) {
            int sum = 0;
            if(check()) answer++;
            return;
        }

        for(int i = current; i <= N; i++) {
            list.add(i);
            dfs(i + 1, count + 1);
            list.remove(list.size() - 1);
        }
    }

    private static boolean check() {
        for(int i = 0; i < Q.length; i++) {
            int count = 0;

            for(int j = 0; j < 5; j++) {
                for(int num: list) {
                    if(num == Q[i][j]) count++;
                }
            }

            if(count != ANSWER[i]) return false;
        }
        return true;
    }
}
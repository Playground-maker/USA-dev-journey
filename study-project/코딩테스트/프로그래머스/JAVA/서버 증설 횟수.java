import java.util.*;

class Solution {

    Queue<Integer> q = new ArrayDeque<>();

    public int solution(int[] players, int m, int k) {

        int answer = 0;

        for(int i = 0; i < players.length; i++) {
            while(!q.isEmpty() && i == q.element()) {
                q.poll();
            }

            int current = players[i];

            if(current / m <= q.size()) {
                continue;
            } else {
                int n = current / m - q.size();

                for(int j = 0; j < n; j++) {
                    q.add(i + k);
                    answer++;
                }
            }
        }

        return answer;
    }
}
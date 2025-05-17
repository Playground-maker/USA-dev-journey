// 프로그래머스 형식

import java.util.*;

class Solution {
    static int[] weightArr;  // 전역용 배열
    static boolean[] visited;
    static int n;
    static int totalCases;

    public int solution(int x, int[] weights) {
        Arrays.sort(weights);

        n = weights.length;
        weightArr = new int[n];
        for (int i = 0; i < n; i++) {
            weightArr[i] = weights[i];
        }

        totalCases = 1;
        for (int i = 0; i < n; i++) {
            totalCases *= 3;
        }

        visited = new boolean[x + 1];

        int answer = bfs(x);
        return answer;
    }

    private int bfs(int salt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{salt, 0});
        visited[salt] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentSalt = current[0];
            int turns = current[1];

            if (currentSalt == 0) return turns;

            // 무게추를 모두 안 쓰는 선택지는 빼야 함
            // 따라서 i = 1부터 시작한다.
            for (int i = 1; i < totalCases; i++) {
                int temp = i;
                int left = 0, right = 0;

                for (int j = 0; j < n; j++) {
                    int choice = temp % 3;
                    if (choice == 1) left += weightArr[j];
                    else if (choice == 2) right += weightArr[j];
                    temp /= 3;
                }

                int diff = Math.abs(left - right);
                int newSalt = currentSalt - diff;

                if (newSalt >= 0 && !visited[newSalt]) {
                    visited[newSalt] = true;
                    queue.add(new int[]{newSalt, turns + 1});
                }
            }
        }

        return -1;
    }
}
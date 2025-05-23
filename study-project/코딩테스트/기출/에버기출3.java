import java.util.*;

class Solution {

    static Set<String> pipeSet = new HashSet<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int[] solution(int[][] outlet, int[][] pipe) {

        // 파이프 경로만 저장
        for (int[] p : pipe) {
            int x1 = p[0];
            int y1 = p[1];
            int x2 = p[2];
            int y2 = p[3];

            if (x1 == x2) {
                // y 방향
                if (y1 > y2) {
                    int temp = y1;
                    y1 = y2;
                    y2 = temp;
                }
                for (int y = y1; y <= y2; y++) {
                    pipeSet.add(x1 + "," + y);
                }
            } else {
                // x 방향
                if (x1 > x2) {
                    int temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
                for (int x = x1; x <= x2; x++) {
                    pipeSet.add(x + "," + y1);
                }
            }
        }

        int[] answer = new int[outlet.length];
        for (int i = 0; i < outlet.length; i++) {
            answer[i] = bfs(outlet[i][0], outlet[i][1]);
        }
        return answer;
    }

    private int bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        String startKey = sx + "," + sy;
        // if (!pipeSet.contains(startKey)) return -1; // 시작점이 파이프가 아닌 경우

        q.add(new int[]{sx, sy, 0});
        visited.add(startKey);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 0, 0 도달 시 거리 반환
            if (x == 0 && y == 0) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                String nextKey = nx + "," + ny;

                if (pipeSet.contains(nextKey) && !visited.contains(nextKey)) {
                    visited.add(nextKey);
                    q.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        // 실제로는 실행되지 않음(단지 컴파일을 위한 장치)
        return -1; // 0,0에 도달할 수 없는 경우
    }

}
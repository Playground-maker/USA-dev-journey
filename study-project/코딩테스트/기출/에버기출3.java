import java.util.*;
import java.io.*;

class Solution {

    static int[][] map;
    static int[][] visited;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int[] solution(int[] outlet, int[][] pipe) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int realMax;
        for(int i = 0; i < pipe.length; i++) {
            for(int j = 0; j < pipe[0].length; j++) {
                realMax = Math.max(max, pipe[i][j]);
            }
        }

        map = new int[realMax * 2 + 1][realMax * 2 + 1];
        visited = new int[realMax * 2 + 1][realMax * 2 + 1];

        for(int i = 0; i < pipe.length; i++) {
            int x1 = pipe[i][0];
            int y1 = pipe[i][1];
            int x2 = pipe[i][2];
            int y2 = pipe[i][3];

            if(x1 == x2) {
                for(int j = y1; j <= y2; j++) {
                    map[x1][j] = 1;
                }
            } else {
                for(int j = x1; j <= x2; j++) {
                    map[j][y1] = 1;
                }
            }
        }

        int[] answer = new int[outlet.length];
        for(int i = 0; i < outlet.length; i++) {
            answer[i] = bfs(outlet[i][0], outlet[i][1]);
        }
        return answer;
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }

        }

        return visited[x][y] - 1;
    }


}
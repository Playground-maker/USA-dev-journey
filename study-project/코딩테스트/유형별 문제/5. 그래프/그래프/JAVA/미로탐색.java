import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] visited;
    static int[][] board;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n+1][m+1];
        board = new int[n+1][m+1];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i + 1][j + 1] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs(1, 1);
        System.out.println(visited[n][m]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= m) {
                    if(visited[nx][ny] == 0 && board[nx][ny] == 1) {
                        visited[nx][ny] = visited[cx][cy] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
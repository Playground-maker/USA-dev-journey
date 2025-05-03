import java.util.*;
import java.io.*;

public class Main {

    static int[][] visited;
    static int[][] board;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int count;
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            visited = new int[N][M];
            count = 0;

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // M : 가로(x) // N : 세로(y)
                board[y][x] = 1;
            }

            for(int k = 0; k < N; k++) {
                for(int j = 0; j < M; j++) {
                    if(visited[k][j] == 0 && board[k][j] == 1) {
                        bfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if(visited[ny][nx] == 0 && board[ny][nx] == 1) {
                        q.add(new int[]{nx, ny});
                        visited[ny][nx] = 1;
                    }
                }
            }
        }

    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int[][] visited;
    static int[][] board;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            board = new int[N+1][M+1];
            visited = new int[N+1][M+1];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // M : 가로(x) // N : 세로(y)
                board[y][x] = 1;
            }

            System.out.println(bfs(0, 0));
        }


    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = 1;
        int area = 1;

        while(!q.isEmpty()) {
            int current = q.poll();
            int cx = current[];
            int cy = current[];

            for(int i = 0; i < 4; i++) {

            }
        }
    }
}
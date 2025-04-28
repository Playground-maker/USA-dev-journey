import java.util.*;
import java.io.*;

public class Main {

    static int count;
    static List<Integer> sizeList;
    static boolean[][] visited;
    static int[][] board;
    static int m, n, k;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        board = new int[m][n];

        count = 0;
        sizeList = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    if(!visited[k][j]) {
                        visited[k][j] = true;
                        board[k][j] = -1;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    sizeList.add(dfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(sizeList, (o1, o2) -> o1 - o2);

        System.out.println(count);
        for(int size: sizeList) {
            System.out.print(size + " ");
        }
    }

    private static int dfs(int x, int y) {

        visited[x][y] = true;
        int area = 1;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(!visited[nx][ny] && board[nx][ny] == 0) {
                    area += dfs(nx, ny);
                }
            }
        }
        return area;
    }

}
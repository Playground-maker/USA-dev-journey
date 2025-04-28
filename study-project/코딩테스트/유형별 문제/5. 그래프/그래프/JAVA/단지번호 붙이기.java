import java.util.*;
import java.io.*;

public class Main {

    static int count;
    static List<Integer> sizeList;
    static boolean[][] visited;
    static int[][] board;
    static int n;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        board = new int[n][n];

        sizeList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j] == 1) {
                    sizeList.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(sizeList);
        System.out.println(count);
        for(int size: sizeList) {
            System.out.println(size);
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int area = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(!visited[nx][ny] && board[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        area++;
                    }
                }
            }
        }

        return area;
    }
}
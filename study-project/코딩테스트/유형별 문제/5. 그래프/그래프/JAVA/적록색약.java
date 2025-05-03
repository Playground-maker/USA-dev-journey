import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int count;

    static int[][] visited;
    static char[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new int[n][n];
        count = 0;

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count).append(" ");


        // R -> G 바꿔줌
        change(map);
        visited = new int[n][n];
        count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count);

        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        char color = map[x][y];

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(visited[nx][ny] == 0 && map[nx][ny] == color) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }

    }

    private static void change(char[][] map) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
    }
}
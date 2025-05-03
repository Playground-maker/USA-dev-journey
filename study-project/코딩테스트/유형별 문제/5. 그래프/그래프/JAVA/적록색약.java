import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static int n;
    static int count;

    static int[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bfs(map)).append(" ");

        // R -> G 바꿔줌
        change(map);
        sb.append(bfs(map));

        System.out.println(sb.toString());
    }

    private static int bfs(char[][] map) {
        Queue<Character> q = new LinkedList<>();
        q.add(map[0][0]);
        count = 0;

        while(!q.isEmpty()) {
            char color = q.poll();
            int nx = x + dx[i];
            int ny = y + dy[i];
            for(int i = 0; i < 4; i++) {

            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(count < visited[i][j]) {
                    count = visited[i][j];
                }
            }
        }

        return count;
    }

    private static void change(char[][] map) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j].equals("R")) {
                    map[i][j] = "G";
                }
            }
        }
    }
}
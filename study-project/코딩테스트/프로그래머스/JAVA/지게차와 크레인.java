// https://why374.tistory.com/26
import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m, answer;
    static char[][] map;
    static boolean[][] visited;

    public int solution(String[] storage, String[] requests) {

        n = storage.length;
        m = storage[0].length();
        answer = n * m;
        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }

        for(String request: requests) {
            if(request.length() == 1) {
                Car(request.charAt(0));
            } else {
                Crane(request.charAt(0));
            }
        }

        return answer;
    }

    private static void Car(char request) {
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            if(!visited[i][0]) dfs(i, 0, request);
            if(!visited[i][m-1]) dfs(i, m-1, request);
        }

        for(int i = 0; i < m; i++) {
            if(!visited[0][i]) dfs(0, i, request);
            if(!visited[n-1][i]) dfs(n-1, i, request);
        }
    }

    private static void Crane(char request) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == request) {
                    answer--;
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void dfs(int x, int y, char request) {
        visited[x][y] = true;

        if(map[x][y] == 0) {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny]) {
                    dfs(nx, ny, request);
                }
            }
        }

        if(map[x][y] == request) {
            answer--;
            map[x][y] = 0;
        }
    }
}
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

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        count = 0;

        // DFS 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 1) {  // 방문하지 않았고 집이 있는 곳만 탐색
                    sizeList.add(dfs(i, j));  // 새로운 단지를 찾고 크기를 리스트에 추가
                    count++;  // 단지 개수 증가
                }
            }
        }

        Collections.sort(sizeList);  // 단지 크기순으로 정렬
        System.out.println(count);    // 단지 개수 출력
        for (int size : sizeList) {
            System.out.println(size);  // 각 단지의 크기 출력
        }
    }

    // 재귀를 사용한 DFS 함수
    private static int dfs(int x, int y) {
        visited[x][y] = true;  // 현재 위치 방문 처리
        int area = 1;  // 현재 단지의 크기, 시작 지점이므로 1부터 시작

        // 네 방향으로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 유효한 범위인지 확인하고, 방문하지 않았고 집이 있는 곳이라면 재귀 호출
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    area += dfs(nx, ny);  // 재귀적으로 연결된 집을 탐색하고 크기를 더함
                }
            }
        }

        return area;  // 단지 크기를 반환
    }
}
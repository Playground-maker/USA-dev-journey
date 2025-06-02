import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int num = n * n;

        int x = 0;
        int y = 0;
        map[x][y] = num;
        int dirNum = 0;

        while(num > 1) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
                map[nx][ny] = --num;
                x = nx;
                y = ny;
            } else {
                dirNum = (dirNum + 1) % 4;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        int targetX = 0;
        int targetY = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == target) {
                    targetX = i;
                    targetY = j;
                    break;
                }
            }
        }

        System.out.print(sb.toString());
        System.out.println((targetX + 1) + " " + (targetY + 1));
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int midX = n/2;
        int midY = n/2;

        int num = 2;
        int dirNum = 0;

        map[midX][midY] = 1;

        while(num <= n * n) {

            if(dirNum > 3) dirNum -= 4;

            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                map[nx][ny] = num;
            }


            num++;
            dirNum++;
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
                }
            }
        }

        System.out.println(sb.toString());
        System.out.println((targetX + 1) + " " + (targetY + 1));
    }
}
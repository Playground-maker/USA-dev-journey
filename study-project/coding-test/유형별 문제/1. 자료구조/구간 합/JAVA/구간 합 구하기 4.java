import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] board = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n + 1];
        sum[0] = board[0];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + board[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end] - sum[start - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
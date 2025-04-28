import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] board = new int[n];
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);
        int start = 0;
        int end = n - 1;
        int count = 0;
        while(start < end) {
            int sum = board[start] + board[end];
            if(sum == m) {
                count++;
                start++;
            } else if(sum < m) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);
    }
}
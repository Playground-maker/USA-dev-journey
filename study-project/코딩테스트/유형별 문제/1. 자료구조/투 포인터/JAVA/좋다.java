import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] board = new int[n];
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);
        int count = 0;

        for(int k = 0; k < n; k++) {
            int start = 0;
            int end = n - 1;
            while(start < end) {
                int sum = board[start] + board[end];
                if(sum == board[k]) {
                    if(start != k && end != k) {
                        count++;
                        break;
                    }
                    if(start == k) start++;
                    else end--;
                } else if(sum < board[k]) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        System.out.println(count);
    }
}
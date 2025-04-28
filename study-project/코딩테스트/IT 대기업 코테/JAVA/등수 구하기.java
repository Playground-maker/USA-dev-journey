import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken()); // 리스트에 있는 점수 n개
        int score = Integer.parseInt(st.nextToken()); // 태수의 점수
        int p = Integer.parseInt(st.nextToken()); // 랭킹에 올라갈 수 있는 점수의 개수

        int[] board = new int[n];
        int rank = 1;

        if(n == 0) {
            System.out.println(1);
            return;
        } else {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            if(n == p) {
                if(board[n-1] >= score) {
                    System.out.println(-1);
                    return;
                }
            }

            for(int i = 0; i < n; i++) {
                if(board[i] > score) {
                    rank++;
                }
            }

            System.out.println(rank);
        }
    }
}
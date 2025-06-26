import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로 H, 가로 W
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int A = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


    }
}
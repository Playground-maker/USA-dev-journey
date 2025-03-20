import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int result = (int)gcd(A, B);

        for(int i = 0; i < result; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {
        while(b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = gcd(a, b);
            result = (a / gcd) * b;
            System.out.println(result);
        }
    }

    private static int gcd(int c, int d) {
        while(d != 0) {
            int temp = d;
            d = c % d;
            c = temp;
        }
        return c;
    }
}
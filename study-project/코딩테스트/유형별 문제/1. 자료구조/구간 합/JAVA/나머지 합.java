import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long sum = 0;
        long[] modArray = new long[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            int mod = (int)(sum % m);
            modArray[mod]++;
        }

        long result = 0;
        result += modArray[0];

        for(int i = 0; i < m; i++) {
            result += (modArray[i] * (modArray[i] - 1)) / 2;
        }

        System.out.println(result);
    }
}
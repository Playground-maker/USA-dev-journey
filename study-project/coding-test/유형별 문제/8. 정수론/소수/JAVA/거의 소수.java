import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        boolean[] isPrime = new boolean[(int)Math.sqrt(B) + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= Math.sqrt(B); i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= Math.sqrt(B); j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 정답 카운트
        int count = 0;

        for(int i = 2; i <= Math.sqrt(B); i++) {
            if(isPrime[i]) {
                long temp = i;
                while(temp <= (double)B / i) {
                    if(temp >= (double)A / i) {
                        count++;
                    }
                    temp *= i;
                }
            }
        }

        System.out.println(count);
    }
}
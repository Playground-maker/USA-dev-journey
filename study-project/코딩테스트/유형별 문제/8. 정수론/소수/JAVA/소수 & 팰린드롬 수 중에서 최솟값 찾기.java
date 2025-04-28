import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 소수 판별을 위한 에라토스테네스의 체
        int max = 2000000; // 넉넉하게 설정
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 2. n 이상인 가장 작은 소수이면서 팰린드롬인 수 찾기
        while (true) {
            if (isPrime[n] && isPalindrome(n)) {
                System.out.println(n);
                return;
            }
            n++;
        }
    }

    // 팰린드롬 판별 함수
    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
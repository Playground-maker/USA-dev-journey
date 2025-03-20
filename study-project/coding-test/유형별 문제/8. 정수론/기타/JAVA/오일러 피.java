// 백준 11689번

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        long result = n;
        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                while(n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }

        if(n > 1) {
            result -= result / n;
        }
        System.out.println(result);
    }
}
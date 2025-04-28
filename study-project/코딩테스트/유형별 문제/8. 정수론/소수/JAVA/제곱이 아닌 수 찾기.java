import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long count = max - min + 1;
        boolean[] check = new boolean[(int)count];

        for(long i = 2; i * i <= max; i++) {
            long pow = i * i; // 제곱수
            long temp = min/pow;  // 제곱수로 나눠지나?
            if(min % pow != 0) { // 제곱수 아니면 +1
                temp += 1;
            }

            for(long j = temp; j * pow <= max; j++) {
                int canSqrt = (int)(j * pow - min);
                if(!check[canSqrt]) {
                    check[canSqrt] = true; // 나누어 떨어지는 수 범위 초과로 -s 해서 저장
                    count--;
                }
            }
        }
        System.out.println(count);
    }
}
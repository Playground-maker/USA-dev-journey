import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> arr;
    static int[] answer;
    static int n, visit;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void cocktail(int num, int mul) { // dfs
        answer[num] *= mul;
        visit |= (1 << num);

        for (int i : arr.get(num)) {
            if ((visit & (1 << i)) == 0) {
                visit |= (1 << i);
                cocktail(i, mul);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, p, q, tmp1, tmp2, div;
        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            answer[i] = 1;
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            tmp1 = answer[b] * p;
            tmp2 = answer[a] * q;
            div = gcd(tmp1, tmp2);
            visit = 0;

            cocktail(a, tmp1 / div);
            cocktail(b, tmp2 / div);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
import java.util.*;
import java.io.*;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //학생 수
            int K = Integer.parseInt(st.nextToken());  // K번쨰 학생

            double[] total = new double[N];

            for (int i =0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int hw = Integer.parseInt(st.nextToken());
                total[i] = mid * 0.35 + fin * 0.45 + hw * 0.2;
            }

            double KScore = total[K-1] ;

            Arrays.sort(total);

            int rank = 0;
            for(int i = 0; i < N; i++) {
                if(total[i] == KScore) {
                    rank = N - i -1;
                }
            }

            int gradeIndex = rank / (N/10) ;

            System.out.println("#" + test_case + " " + grade[gradeIndex]);

        }
    }
}
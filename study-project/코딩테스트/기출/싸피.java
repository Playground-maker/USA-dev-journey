import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferdReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int k = 1; k <= test_case; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            int minDistance = Integer.MAX_VALUE;

            for(int skip = 0; skip < n; skip++) {
                int dist = 0;
                int prev = -1;

                for(int i = 0; i < n; i++) {
                    if(i == skip) continue;
                    if(prev == -1) {
                        prev = A[i];
                    } else {
                        dist += getClockwiseDistance(prev, A[i], m);
                        prev = A[i];
                    }
                }

                minDistance = Math.min(minDistance, dist);
            }

            System.out.println("#" + k + " " + minDistance);
        }
    }

    private static int getClockwiseDistance(int from, int to, int m) {
        return (to > from) ? (to - from) : (m + to - from);
    }
}
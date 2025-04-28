import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        result = new int[n+1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            bfs(i);
        }

        int big = 0;
        for(int i = 1; i <= n; i++) {
            big = Math.max(big, result[i]);
        }

        for(int i = 1; i <= n; i++) {
            if(result[i] == big) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next: graph.get(current)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    result[next]++;
                }
            }
        }
    }
}
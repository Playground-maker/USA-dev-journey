import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> graph;
    static int[] visited;

    static int n, m, k, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
        }


        visited = new int[n+1];
        Arrays.fill(visited, -1);

        bfs(x);

        boolean found = false;
        for(int i = 1; i <= n; i++) {
            if(visited[i] == k) {
                System.out.println(i);
                found = true;
            }
        }

        if(!found) {
            System.out.println(-1);
        }
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 0;

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next: graph.get(current)) {
                if(visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    q.add(next);
                }
            }
        }
    }
}
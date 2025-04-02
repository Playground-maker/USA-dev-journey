import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static boolean isBinaryGraph;

    static List<List<Integer>> graph;
    static char[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n+1];
            color = new char[n+1];
            Arrays.fill(color, 'X');
            isBinaryGraph = true;

            graph = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    color[i] = 'A';
                    dfs(i);
                }
            }

            System.out.println(isBinaryGraph ? "YES" : "NO");
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                color[neighbor] = (color[node] == 'A') ? 'B' : 'A';
                dfs(neighbor);
            } else {
                if(color[neighbor] == color[node]) {
                    isBinaryGraph = false;
                }
            }
        }

    }
}
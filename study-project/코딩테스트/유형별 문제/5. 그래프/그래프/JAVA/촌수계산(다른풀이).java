import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int result = -1;  // 촌수 결과
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);  // 양방향
        }

        dfs(start, 0);

        System.out.println(result);
    }

    static void dfs(int current, int depth) {
        visited[current] = true;

        if (current == end) {
            result = depth;
            return;
        }

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}
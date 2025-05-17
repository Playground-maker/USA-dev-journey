// 이분 그래프와 유사한 문제

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        findMaxIndependentSet(1, 0);
        System.out.println(maxCount);
    }

    static void findMaxIndependentSet(int node, int count) {
        if (node > n) {
            maxCount = Math.max(maxCount, count);
            return;
        }

        // 현재 노드를 선택하지 않는 경우
        findMaxIndependentSet(node + 1, count);

        // 현재 노드를 선택할 수 있는지 확인
        boolean canSelect = true;
        for (int neighbor : graph[node]) {
            if (visited[neighbor]) {
                canSelect = false;
                break;
            }
        }

        if (canSelect) {
            // 현재 노드를 선택하는 경우
            visited[node] = true;
            findMaxIndependentSet(node + 1, count + 1);
            visited[node] = false;
        }
    }
}
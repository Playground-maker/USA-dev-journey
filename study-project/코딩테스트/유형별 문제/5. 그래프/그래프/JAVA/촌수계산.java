import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new int[n+1];
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(start);

        if(visited[end] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(visited[end] - 1);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next: graph.get(current)) {
                if(visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    q.add(next);
                }
            }
        }
    }
}
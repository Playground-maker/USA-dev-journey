import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] list;

    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            dfs(i, i);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    static void dfs(int start, int current) {
        if(!visited[current]) {
            visited[current] = true;
            dfs(start, list[current]);
        } else if(start == current) {
            result.add(start);
        }
    }
}
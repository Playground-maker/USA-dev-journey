// https://velog.io/@dawonseo/Java%EB%B0%B1%EC%A4%80-2251-%EB%AC%BC%ED%86%B5
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> ans = new ArrayList<>();
    // 2차원 배열 사용
    static boolean[][] visited;
    static int A, B, C;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();

        visited = new boolean[A + 1][B + 1];
        DFS(0, 0, C);

        ans.sort((o1, o2) -> o1 - o2);

        StringBuilder sb = new StringBuilder();

        for (int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }

    static void DFS(int a, int b, int c) {
        // 이미 방문한 적 있다면 재귀를 종료한다
        if (visited[a][b]) return;
        // A에 담긴 물의 양이 0이면 C에 담긴 물의 양을 ans 배열에 추가한다
        if (a == 0) {
            ans.add(c);
        }
        // 방문 체크
        visited[a][b] = true;

        if (a != 0) {
            int tmp1 = Math.min(a, B - b);
            DFS(a - tmp1, b + tmp1, c);
            int tmp2 = Math.min(a, C - c);
            DFS(a - tmp2, b, c + tmp2);
        }

        if (b != 0) {
            int tmp1 = Math.min(b, A - a);
            DFS(a + tmp1, b - tmp1, c);
            int tmp2 = Math.min(b, C - c);
            DFS(a, b - tmp2, c + tmp2);
        }

        if (c != 0) {
            int tmp1 = Math.min(c, A - a);
            DFS(a + tmp1, b, c - tmp1);
            int tmp2 = Math.min(c, B - b);
            DFS(a, b + tmp2, c - tmp2);
        }
    }
}
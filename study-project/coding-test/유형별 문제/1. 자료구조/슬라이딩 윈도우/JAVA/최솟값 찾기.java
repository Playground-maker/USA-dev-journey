import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {

            int value = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.peekLast()[1] > value) {
                deque.pollLast();
            }

            deque.offerLast(new int[]{i, value});

            if(deque.peekFirst()[0] < i - l + 1) {
                deque.pollFirst();
            }

            sb.append(deque.peekFirst()[1]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String command = st.nextToken();

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        int count = 0;
        int number = 0;

        switch(command) {
            case "Y":
                number = set.size();
                count = number;
                System.out.println(count);
                break;

            case "F":
                number = set.size();
                count = number / 2;
                System.out.println(count);
                break;

            case "O":
                number = set.size();
                count = number / 3;
                System.out.println(count);
                break;
        }
    }
}
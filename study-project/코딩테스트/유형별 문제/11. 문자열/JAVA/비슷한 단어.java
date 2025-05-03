import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        int max = 0;
        int ans1 = 0, ans2 = 0;

        for(int i = 0; i < n - 1; i++) {
            String s1 = list.get(i);
            for(int j = i + 1; j < n; j++) {
                String s2 = list.get(j);
                int len = 0;
                while(len < s1.length() && len < s2.length() && s1.charAt(len) == s2.charAt(len)) {
                    len++;
                }
                if(len > max) {
                    max = len;
                    ans1 = i;
                    ans2 = j;
                }
            }
        }

        System.out.println(list.get(ans1));
        System.out.println(list.get(ans2));
    }
}
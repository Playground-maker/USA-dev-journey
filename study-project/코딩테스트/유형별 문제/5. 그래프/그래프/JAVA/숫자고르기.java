import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int count;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list.add(0);
        for(int i = 1; i <= n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }


    }
}
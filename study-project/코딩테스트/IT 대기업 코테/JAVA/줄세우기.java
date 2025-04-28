import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        int[] array = new int[20];
        int number = 0;

        for(int i = 0; i < p; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 20; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            for(int current = 0; current < 20; current++) {
                for(int k = 0; k < current; k++) {
                    if(array[current] < array[k]) {
                        count++;
                    }
                }
            }

            System.out.println(number + " " + count);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int total = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a') total++;
        }

        int aMax = 0;
        for(int i = 0; i < str.length(); i++) {
            int aCount = 0;

            for(int j = 0; j < total; j++) {
                int index = 0;
                if(i + j < str.length()) {
                    index = i + j;
                } else {
                    index = i + j - str.length();
                }

                if(str.charAt(index) == 'a') aCount++;
                if(aCount > aMax) aMax = aCount;
            }
        }

        System.out.println(total - aMax);
    }
}
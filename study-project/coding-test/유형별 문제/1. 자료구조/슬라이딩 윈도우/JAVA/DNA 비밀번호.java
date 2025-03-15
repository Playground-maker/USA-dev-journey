import java.io.*;
import java.util.*;

public class Main {

    static int validCount;
    static int[] currentCount = new int[4];
    static int[] requiredCount = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            requiredCount[i] = Integer.parseInt(st.nextToken());
            if(requiredCount[i] == 0) validCount++;
        }

        for(int i = 0; i < P; i++) {
            addChar(dna[i]);
        }

        int result = (validCount == 4) ? 1 : 0;

        for(int i = P; i < S; i++) {
            int removeIndex = i - P;
            addChar(dna[i]);
            removeChar(dna[removeIndex]);

            if(validCount == 4) result++;
        }

        System.out.println(result);
    }

    private static int getCharIndex(char c) {
        switch(c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1;
        }
    }

    private static void addChar(char c) {
        int index = getCharIndex(c);
        currentCount[index]++;
        if(currentCount[index] == requiredCount[index]) validCount++;
    }

    private static void removeChar(char c) {
        int index = getCharIndex(c);
        if(currentCount[index] == requiredCount[index]) validCount--;
        currentCount[index]--;
    }
}
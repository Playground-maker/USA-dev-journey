import java.util.*;
import java.io.*;

public class Main {
    static int heartX = 0;
    static int heartY = 0;
    static int headX = 0;
    static int headY = 0;
    static String[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new String[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = st.nextToken();
            }
        }

        findHeadandHeart();
        int leftHandCount = 0;
        int rightHandCount = 0;

        for(int i = heartX; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '*' && j < ) {

                } else if() {

                }
            }
        }

        int waistCount = 0;
        int waistEnd;
        for(int i = heartX; i < n; i++) {
            if(board[i][heartY] == '*') {
                waistCount++;
            } else {
                waistEnd = i;
                break;
            }
        }

        int leftLegCount = 0;
        int rightLegCount = 0;
        for(int i = waistEnd + 1; i < n; i++) {
            if(board[i][heartY - 1] == '*') {
                leftLegCount++;
            } else if(board[i][heartY - 1] == '_' || ) {

            }
        }
        for(int i = waistEnd + 1; i < n; i++) {
            if(board[i][heartY + 1] == '*') {
                rightLegCount++;
            } else if() {

            }
        }
        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println((leftHandCount) + " " + (rightHandCount) + " " + (waistCount) + " " + (leftLegCount) + " " + (rightLegCount));
    }

    private static void findHeadandHeart() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '*') {
                    headX = i;
                    headY = j;
                    heartX = i + 1;
                    heartY = j;
                    return;
                }
            }
        }
    }
}
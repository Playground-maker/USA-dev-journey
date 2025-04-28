import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        switches = new int[n]; // 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken()); // 올바른 방식으로 배열 채우기
        }

        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());
            simulation(sex, switchNum);
        }

        printSwitches();
    }

    private static void simulation(int sex, int switchNum) {
        if (sex == 1) { // 남학생 (배수 위치 변경)
            for (int i = switchNum - 1; i < n; i += switchNum) {
                switches[i] = switches[i] == 1 ? 0 : 1;
            }
        } else { // 여학생 (대칭 확인 후 변경)
            int index = switchNum - 1;
            switches[index] = switches[index] == 1 ? 0 : 1;

            int left = index - 1;
            int right = index + 1;

            while (left >= 0 && right < n && switches[left] == switches[right]) {
                switches[left] = switches[left] == 1 ? 0 : 1;
                switches[right] = switches[right] == 1 ? 0 : 1;
                left--;
                right++;
            }
        }
    }

    private static void printSwitches() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(switches[i]).append(" ");
            if ((i + 1) % 20 == 0) sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
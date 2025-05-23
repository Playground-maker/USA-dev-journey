import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] arms) {
        boolean[] stopped = new boolean[m];
        int stoppedCount = 0;
        int time = 1;

        int stopRow = -1;  // 멈추는 행이 아직 정해지지 않음
        int[] stoppedPositions = new int[m];  // 멈춘 팔 위치 저장

        while (stoppedCount < m) {
            for (int i = 0; i < m; i++) {
                if (!stopped[i]) {
                    int pos = getPosition(n, arms[i][0], arms[i][1], time);

                    if (stopRow == -1 || stopRow == pos) {
                        stopped[i] = true;
                        stoppedPositions[i] = pos;
                        stoppedCount++;

                        if (stopRow == -1) {
                            stopRow = pos;
                        }
                        break;  // 한 번에 한 팔만 멈춤
                    }
                }
            }
            if (stoppedCount == m) return time;
            time++;
        }
        return time;
    }

    private int getPosition(int n, int startRow, int direction, int t) {
        int pos = startRow;
        int dir = direction;

        for (int i = 0; i < t; i++) {
            pos += dir;
            if (pos == n) dir = -1;
            else if (pos == 1) dir = 1;
        }
        return pos;
    }
}
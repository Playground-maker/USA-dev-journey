// 배열 압축 문제

import java.util.*;

class Solution {
    public static int[] solution(int[][] mapdata, int k) {
        int n = mapdata.length;
        int m = mapdata[0].length;
        int[][] compressed = new int[n / k][m / k];
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < n; i += k) {
            for (int j = 0; j < m; j += k) {
                Map<Integer, Integer> countMap = new HashMap<>();

                // k x k 블록 내 숫자 카운트
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        int num = mapdata[x][y];
                        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                    }
                }

                // 최다 빈도 + 큰 숫자 선택
                int maxCount = 0;
                int selected = Integer.MIN_VALUE;
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    int num = entry.getKey();
                    int count = entry.getValue();
                    if (count > maxCount || (count == maxCount && num > selected)) {
                        maxCount = count;
                        selected = num;
                    }
                }

                compressed[i / k][j / k] = selected;
            }
        }

        // 2차원 결과를 1차원 배열로 변환
        for (int i = 0; i < compressed.length; i++) {
            for (int j = 0; j < compressed[0].length; j++) {
                answerList.add(compressed[i][j]);
            }
        }

        // 리스트를 int[]로 변환 후 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> extensionCount = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String fileName = br.readLine();
            String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
            extensionCount.put(extension, extensionCount.getOrDefault(extension, 0) + 1);
        }

        List<String> keys = new ArrayList<>(extensionCount.keySet());
        Collections.sort(keys);

        for(String key: keys) {
            System.out.println(key + " " + extensionCount.get(key));
        }
    }
}
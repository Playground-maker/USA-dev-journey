import java.util.*;
import java.io.*;

public class Main {

    static int p, m, l;
    static String n;

    static class room {
        int size;
        int criteria;

        public room(int size, int criteria) {
            this.size = size;
            this.criteria = criteria;
        }
    }

    static class player {
        int level;
        String nickname;

        public player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());


        }




    }


}
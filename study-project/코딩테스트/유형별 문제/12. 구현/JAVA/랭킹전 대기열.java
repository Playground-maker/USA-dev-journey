import java.util.*;
import java.io.*;

public class Main {

    static int p, m, l;
    static String n;

    static class Room {
        int criteria;
        List<Player> players = new ArrayList<>();

        public Room(int criteria) {
            this.criteria = criteria;
        }
    }

    static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // p : 플레이어의 수
        // m : 방의 최대 인원수
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = st.nextToken();

            boolean entered = false;

            for(Room room: rooms) {
                if(room.players.size() < m && Math.abs(room.criteria - l) <= 10) {
                    room.players.add(new Player(l, n));
                    entered = true;
                    break;
                }
            }

            if(!entered) {
                Room newRoom = new Room(l);
                newRoom.players.add(new Player(l, n));
                rooms.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Room room: rooms) {
            if(room.players.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            room.players.sort((p1, p2) -> p1.nickname.compareTo(p2.nickname));

            for(Player player: room.players) {
                sb.append(player.level).append(" ").append(player.nickname).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
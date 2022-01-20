import java.util.*;
import java.io.*;

public class Ex1931sol3 {
    // 7:40
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[tc];

        for(int i = 0; i < rooms.length; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(start, end);
        }

        Arrays.sort(rooms, new Comparator<Room>() {

            @Override
            public int compare(Room r1, Room r2) {
                if((r1.end - r2.end) == 0) return r1.start - r2.start;
                return r1.end - r2.end;
            }
        });

        int cnt = 0;
        int cur = 0;
        for(int i = 0; i < rooms.length; i++){
            Room room = rooms[i];

            if(cur <= room.start) {
                cnt++;
                cur = room.end;
            }
        }

        sb.append(cnt);
        System.out.println(sb);  

    }

    static class Room {
        int start, end;

        public Room(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

}

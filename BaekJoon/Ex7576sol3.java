import java.util.*;
import java.io.*;

public class Ex7576sol3 {
    // 4: 26
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static Queue<Point> queue = new LinkedList<Point>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        isVisited = new boolean[y][x];

        for(int i = 0; i < y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) queue.offer(new Point(j, i));
                map[i][j] = num;
            }
        }

        int minDay = getMinDay();
        minDay = minDay == -1 ? -1 : minDay - 1; 
        sb.append(minDay);
        System.out.println(sb);
    }

    public static int getMinDay(){
        int day = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++){
                Point point = queue.poll();
                map[point.y][point.x] = 1;
                for(int i = 0; i < 4; i++){
                    int xx = point.x + dx[i];
                    int yy = point.y + dy[i];
    
                    if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map.length) continue;
                    if(map[yy][xx] != 0 || isVisited[yy][xx]) continue;
    
                    isVisited[yy][xx] = true;
                    queue.offer(new Point(xx ,yy));
                }
            }
            day++;
        }

        return checkNotRipedTomato() ? day : -1;
    }

    public static boolean checkNotRipedTomato(){
        boolean isRiped = true;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == 0) isRiped = false;
            }
        }
        
        return isRiped;
    }

    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}

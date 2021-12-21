import java.util.*;
import java.io.*;

public class Ex2667sol4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        map = new int[tc][tc];
        isVisited = new boolean[tc][tc];

        // input map data
        for(int i = 0; i < tc; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int townCnt = 0;
        LinkedList<Integer> aptCntList = new LinkedList<Integer>();
        for(int i = 0; i < tc; i++){
            for(int j = 0; j < tc; j++){
                if(!isVisited[i][j] && map[i][j] == 1) {
                    townCnt++;
                    int aptCnt = bfs(j, i, townCnt);
                    aptCntList.add(aptCnt);
                }
            }
        }

        Collections.sort(aptCntList);

        sb.append(townCnt).append("\n");
        for(int i = 0; i < aptCntList.size(); i++){
            sb.append(aptCntList.get(i)).append("\n");
        }
        System.out.println(sb);
        
    }

    public static int bfs(int x, int y, int townCnt){
        Queue<Point> queue = new LinkedList<Point>();
        isVisited[y][x] = true;
        queue.offer(new Point(x, y));
        map[y][x] = townCnt;
        int aptCnt = 1; 
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0; i < 4; i++){
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];

                if(xx < 0 || xx >= map[0].length || yy < 0 || yy >= map[0].length) continue;
                if(map[yy][xx] == 0 || isVisited[yy][xx]) continue;

                map[yy][xx] = aptCnt;
                isVisited[yy][xx] = true;
                queue.offer(new Point(xx ,yy));
                aptCnt++;
            }
        }

        return aptCnt;
    }

    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

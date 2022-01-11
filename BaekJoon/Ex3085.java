import java.util.*;
import java.io.*;

public class Ex3085 {
    // 5: 37
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());

        //input DATA
        map = new char[tc][tc];
        for(int i = 0; i < tc; i++) {
            String line = br.readLine();
            for(int j = 0; j < tc; j++){
                char cur = line.charAt(j);
                map[i][j] = cur;
            }
        }
        int max = 0;
        for(int i = 0; i < tc; i++) {
            for(int j = 0; j < tc; j++){
                max = Math.max(max, ps(j, i));
            }
        }

        sb.append(max);
        System.out.println(sb);
    }

    public static int ps(int x, int y){
        int max = 0;
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx < 0 || yy < 0 || xx >= map.length || yy >= map.length) continue;

            changeChar(x, y, xx, yy);

            max = Math.max(max, countBiggestCandy());

            changeChar(xx, yy, x, y);
        }

        return max;
    }

    public static void changeChar(int x, int y, int xx, int yy){
        char temp = map[y][x];
        map[y][x] = map[yy][xx];
        map[yy][xx] = temp;
    }

    public static int countBiggestCandy(){

        int max = 0;
        for(int i = 0; i < map.length; i++) {
            int cnt = 1;
            char cur = map[i][0];
            for(int j = 1; j < map.length; j++) { 
                if(cur != map[i][j]){ 
                    max = Math.max(max, cnt);
                    cur = map[i][j];
                    cnt = 1;
                }else {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        for(int i = 0; i < map.length; i++) {
            int cnt = 1;
            char cur = map[0][i];
            for(int j = 1; j < map.length; j++) { 
                if(cur != map[j][i]){ 
                    max = Math.max(max, cnt);
                    cur = map[j][i];
                    cnt = 1;
                }else {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        return max;
    }
}

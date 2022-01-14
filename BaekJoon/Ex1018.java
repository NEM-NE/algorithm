import java.util.*;
import java.io.*;

public class Ex1018 {
    // 4: 00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[][] map;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] inputAry = br.readLine().split(" ");
        int y = Integer.parseInt(inputAry[0]);
        int x = Integer.parseInt(inputAry[1]);

        map = new boolean[y][x];

        for(int i = 0; i < y; i++){
            String line = br.readLine();
            for(int j = 0; j < x; j++){
                boolean isWhite = (line.charAt(j) == 'W') ? true : false;
                map[i][j] = isWhite;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < y - 7; i++){
            int startY = i;
            int endY = i + 7;

            for(int j = 0; j < x - 7; j++){
                int startX = j;
                int endX = j + 7;

                min = Math.min(Math.min(ps(startX, startY, endX, endY, true), ps(startX, startY, endX, endY, false)), min);
            }
        }

        sb.append(min);
        System.out.println(sb);
        
    }

    public static int ps(int startX, int startY, int endX, int endY, boolean isReverse) {
        boolean curColor = (isReverse) ? !map[startY][startX] : map[startY][startX];
        int changeCnt = 0;

        for(int i = startY; i <= endY; i++){
            for(int j = startX; j <= endX; j++){
                if(curColor != map[i][j]) changeCnt++;
                curColor = !curColor;
            }
            curColor = !curColor;
        }

        return changeCnt;
    }

}

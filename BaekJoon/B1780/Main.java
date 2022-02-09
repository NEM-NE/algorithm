package B1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    //3:05
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static HashMap<Integer, Integer> result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        map = new int[tc][tc];
        result = new HashMap<Integer, Integer>();

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < tc; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, tc-1, 0, tc-1, tc);

        sb.append(result.getOrDefault(-1, 0)).append('\n');
        sb.append(result.getOrDefault(0, 0)).append('\n');
        sb.append(result.getOrDefault(1, 0)).append('\n');
        System.out.println(sb);
    }

    public static void solve(int xStart, int xEnd, int yStart, int yEnd, int size) {
        boolean isSame = checkPaper(xStart, xEnd, yStart, yEnd);
        if(isSame){
            int num = map[yStart][xStart];
            result.put(num, result.getOrDefault(num, 0) + 1);
        }else {
            int newSize = size/3;
            solve(xStart, (xStart + newSize) - 1, yStart, (yStart + newSize) - 1, newSize);
            solve(xStart + newSize, (xStart + 2 * newSize) - 1, yStart, (yStart + newSize) - 1, newSize);
            solve((xStart + 2 * newSize), xEnd, yStart, (yStart + newSize) - 1, newSize);

            solve(xStart, (xStart + newSize) - 1, yStart + newSize, (yStart + 2 * newSize) - 1, newSize);
            solve(xStart + newSize, (xStart + 2 * newSize) - 1, yStart + newSize, (yStart + 2 * newSize) - 1, newSize);
            solve((xStart + 2 * newSize), xEnd, yStart + newSize, (yStart + 2 * newSize) - 1, newSize);

            solve(xStart, (xStart + newSize) - 1, (yStart + 2 * newSize), yEnd, newSize);
            solve(xStart + newSize, (xStart + 2 * newSize) - 1, (yStart + 2 * newSize), yEnd, newSize);
            solve((xStart + 2 * newSize), xEnd, (yStart + 2 * newSize), yEnd, newSize);
        }
    }

    public static boolean checkPaper(int xStart, int xEnd, int yStart, int yEnd) {
        int num = map[yStart][xStart];
        for(int i = yStart; i <= yEnd; i++){
            for(int j = xStart; j <= xEnd; j++){
                if(map[i][j] != num) return false;
            }
        }
        return true;
    }
}

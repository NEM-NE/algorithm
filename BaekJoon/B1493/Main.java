package B1493;

import java.util.*;
import java.io.*;

public class Main {
    // 3:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][][] box;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        box = new int[height][width][length];

        int tc = Integer.parseInt(br.readLine());
        int[] cubes = new int[tc];
        for(int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            cubes[idx] = size;
        }

        int sum = 0;
        for(int i = cubes.length - 1; i >= 0; i--){
            int count = cubes[i];
            for(int j = 0; j < count; j++){
                boolean result = insertCube(i);
                if(result) sum++;
            }
        }

        sb.append(sum);
        System.out.println(sb);

    }

    static boolean insertCube(int size) {
        return true;
    }
}

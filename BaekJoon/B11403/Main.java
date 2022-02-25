package B11403;

import java.util.*;
import java.io.*;

public class Main {
    // 3:35
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> map;
    static int[][] result;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        map = new ArrayList<ArrayList<Integer>>();
        result = new int[tc][tc];

        for(int i = 0; i < tc; i++){
            map.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < tc; j++){
                int num = Integer.parseInt(st.nextToken());

                if(num == 1){
                    map.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < tc; i++){
            if(map.get(i).size() != 0){
                dfs(i, i);
            }
        }

        for(int i = 0; i < tc; i++){
            for(int j = 0; j < tc; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int startNum, int lineNum){
        for(int i = 0; i < map.get(startNum).size(); i++){
            if(result[lineNum][map.get(startNum).get(i)] != 1){
                result[lineNum][map.get(startNum).get(i)] = 1;
                dfs(map.get(startNum).get(i), lineNum);
            }
        }
    }

}

package B9466;

import java.util.*;
import java.io.*;

public class Main {
    // 12:16
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] map;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            map = new int[num+1];
            visited = new boolean[num+1];
            finished = new boolean[num+1];
            solve(num);
            sb.append(num-cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int num){
        cnt = 0;

        for(int i = 1; i <= num; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= num; i++){
            if(!visited[i]) dfs(i);
        }
    }

    private static void dfs(int start){
        visited[start] = true;
        int next = map[start];

        if(visited[next]){
            if(!finished[next]){
                for (int i = next; i != start; i = map[i]) cnt++;
                cnt++;
            }
        }else {
            dfs(next);
        }
        finished[start] = true;
    }

}

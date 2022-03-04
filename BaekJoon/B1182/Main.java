package B1182;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] ary;
    static boolean[] visited;
    static int s;
    static int cnt;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ary = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, ary[i]);
            visited[i] = false;
        }

        sb.append(cnt);
        System.out.println(sb);
    }

    private static void dfs(int index, int sum){
        if(sum == s) {
            cnt++;
        }

        for(int i = index+1; i < ary.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,sum + ary[i]);
                visited[i] = false;
            }
        }

    }
}

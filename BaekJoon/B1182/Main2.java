package B1182;

import java.io.*;
import java.util.*;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] list;
    static boolean[] vistied;
    static int cnt;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        list = new int[n];
        vistied = new boolean[n];
        cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
        }

        for(int i = 0; i < n; i++){
            vistied[i] = true;
            dfs(list[i], s, i);
            vistied[i] = false;
        }

        sb.append(cnt);
        System.out.println(sb);
    }

    public static void dfs(int sum, int s, int idx){
        if(sum == s){
            cnt++;
        }

        for(int i = idx; i < list.length; i++){
            if(vistied[i]) continue;
            vistied[i] = true;
            dfs(sum + list[i], s, i+1);
            vistied[i] = false;
        }
    }
}

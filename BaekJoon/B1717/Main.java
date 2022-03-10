package B1717;

import java.io.*;
import java.util.*;

public class Main {
    // 11:30
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //makeset
        parent = new int[n+1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(oper == 0) {
                union(parent, a, b);
            }else if(oper == 1) {
                int aa = find(parent, a);
                int bb = find(parent, b);

                sb.append(aa == bb ? "YES" : "NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int find(int[] parent, int a){
        if(parent[a] == a) {
            return a;
        }else {
            return parent[a] = find(parent, parent[a]);
        }
    }

    private static void union(int[] parent, int a, int b){
        int aa = find(parent, a);
        int bb = find(parent, b);

        if(aa > bb) {
            parent[aa] = bb;
        }else {
            parent[bb] = aa;
        }
    }

}

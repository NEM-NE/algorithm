package B15650;

import java.io.*;
import java.util.*;

public class Main {
    //15:33
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<String> list;
    static int N;
    static int M;


    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<String>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs("", 1, 0);

        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            for(int j = 0; j < str.length(); j++){
                sb.append(str.charAt(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(String str, int idx, int depth){
        if(M == depth){
            list.add(str);
            return;
        }

        for(int i = idx; i <= N; i++){
            dfs(str + i, i+1, depth+1);
        }
    }
}

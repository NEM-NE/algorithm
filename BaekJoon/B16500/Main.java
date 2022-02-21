package B16500;

import java.util.*;
import java.io.*;

public class Main {
    // 12:07
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dp;
    static Set<String> set;
    static String str;

    public static void main(String[] args) throws NumberFormatException, IOException {
        str = br.readLine();
        int tc = Integer.parseInt(br.readLine());
        dp = new int[str.length() + 1];
        set = new HashSet<String>();
        for(int i = 0; i < tc; i++){
            set.add(br.readLine());
        }

        for(int i = str.length() - 1; i >= 0; i--){
            for(int j = str.length() - 1; j > i; j--){
                if(dp[j] == 1){
                    if(set.contains(str.substring(i, j))){
                        dp[i] = 1;
                    }
                }
            }
            if(set.contains(str.substring(i))) dp[i] = 1;
        }

        sb.append(dp[0]);
        System.out.println(sb);
    }

}

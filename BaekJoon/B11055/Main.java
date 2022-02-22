package B11055;

import java.util.*;
import java.io.*;

public class Main {
    // 16:09
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[tc];
        int[] ary = new int[tc];
        for(int i = 0; i < tc; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = tc - 1; i >= 0; i--){
            dp[i] = ary[i];
            for(int j = i + 1; j < tc; j++){
                if(ary[i] < ary[j]){
                    dp[i] = Math.max(dp[i], dp[j] + ary[i]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < tc; i++){
            max = Math.max(max, dp[i]);
        }

        sb.append(max);
        System.out.println(sb);

    }

}

package B2294;

import java.io.*;
import java.util.*;

public class Main {
    // 2:04
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dp;
    static int[] coinAry;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        dp = new int[10001];

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        coinAry = new int[n];
        for(int i = 0; i < n; i++){
            coinAry[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coinAry);

        dp[0] = 0;
        for(int i = 1; i <= k; i++){
            if(i >= coinAry[0]){
                dp[i] = dp[i - coinAry[0]] + 1;
                if(dp[i] == 0) dp[i] = Integer.MAX_VALUE;
                for(int j = 1; j < coinAry.length; j++) {
                    int index = i - coinAry[j];
                    if(index >= 0){
                        if (dp[i - coinAry[j]] == -1) continue;
                        int num = dp[i - coinAry[j]];
                        dp[i] = Math.min(dp[i], num + 1);
                    }
                }

                if(dp[i] == Integer.MAX_VALUE) dp[i] = -1;
            }else {
                dp[i] = -1;
            }
        }

        int result = dp[k];
        sb.append(result);
        System.out.println(sb);
    }
}

/*

2 10
2
3

1 4
5

1 1000
999

1 10000
10001

1 9
3

7 8
1
2
3
4
5
6
7

 */
package B2294;

import java.io.*;
import java.util.*;

public class Main3 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int[] dp = new int[10001];
  static int[] coins;
  //11:28
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    coins = new int[n];
    for(int i = 0; i < coins.length; i++){
      coins[i] = Integer.parseInt(br.readLine());
    }

    for(int i = 0; i < coins.length; i++){
      if(coins[i] <= 10000) {
        dp[coins[i]] = 1;
      }
    }
    int result = solve(k);
    result = result == 10001 ? -1 : result;

    sb.append(result);
    System.out.println(sb);
  }

  public static int solve(int k){
    if(dp[k] != 0){
      return dp[k];
    }

    int min = 10001;
    for(int i = 0; i < coins.length; i++){
      if(k - coins[i] > 0 && coins[i] <= 10000){
        int result = solve(k - coins[i]) + solve(coins[i]);
        min = Math.min(min, result);
      }
    }

    dp[k] = min;

    return dp[k];
  }

}

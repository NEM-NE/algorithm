package B12865;

import java.util.*;
import java.io.*;

public class Main {
    // 11:42
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] dp;

    static class Product {
        int weight, value;

        public Product(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][k+1];

        Product[] products = new Product[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            products[i] = new Product(weight, value);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= products[i-1].weight){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-products[i-1].weight] + products[i-1].value);
                }
            }
        }

        sb.append(dp[n][k]);
        System.out.println(sb);

    }

}

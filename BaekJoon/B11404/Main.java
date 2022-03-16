package B11404;

import java.io.*;
import java.util.*;

public class Main {
    // 11:30
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] dist;
    static final int INF = 10000001;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n+1][n+1];

        // 0개 간선으로 연결
        for(int i = 1; i <= n; i++){
            for(int k = 1; k <= n; k++){
                if(i == k) dist[i][k] = 0;
                else dist[i][k] = INF;
            }
        }

        // 1개 간선으로 연결
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], w);
        }

        // n개의 간선으로 연결
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int[] result = dist[i];
            for(int j = 1; j <= n; j++){
                if(result[j] == INF){
                    sb.append(0).append(" ");
                }else sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

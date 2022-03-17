package B11403;

import java.io.*;
import java.util.*;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] dist;

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        dist = new int[n][n];

        //0
        for(int i = 0; i < dist.length; i++){
            for(int j = 0; j < dist.length; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = 2;
            }
        }

        //1
        for(int i = 0; i < dist.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < dist.length; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    dist[i][j] = 1;
                }
            }
        }


        //n
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] == 1 && dist[k][j] == 1){
                        dist[i][j] = 1;
                    }
                }
            }
        }

        for(int[] line : dist){
            for(int num : line){

                sb.append(num == 1 ? num : 0).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

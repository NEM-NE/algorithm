package B2805;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++){
            ary[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, ary[i]);
        }

        int min = 0;
        int result = 0;
        while((min+1) < max){
            int mid = (max + min) / 2;

            long sum = 0;
            for(int length : ary){
                sum += (length <= mid) ? 0 : length - mid;
            }

            if(sum == m) {
                result = mid;
                break;
            }

            if(sum < m){
                max = mid;
            }else {
                min = mid;
                result = mid;
            }
        }

        sb.append(result);
        System.out.println(sb);

    }
}

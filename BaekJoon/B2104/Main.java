package B2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //12:02
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] ary;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ary = new int[n];

        for(int i = 0; i < ary.length; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        long result = solve(0, n);
        sb.append(result);
        System.out.println(result);
    }

    public static long solve(int i, int j) {
        if(i == j) return cal(i, i);
        if((i+1) == j) return cal(j, j);
        int mid = (i + j) / 2;

        long result = Math.max(solve(i, mid-1), solve(mid, j-1));




        return result;
    }

    public static long cal(int a, int b) {
        long sumA = 0;
        long sumB = Integer.MAX_VALUE;
        for(int i = a; i <= b; i++){
            sumA += ary[i];
            sumB = Math.min(sumB, ary[i]);
        }

        return sumA * sumB;
    }
}

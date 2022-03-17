package B1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    // 11:53
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long sum = 0;
        sum = divideConquer(a, b, c);
        sb.append(sum);
        System.out.println(sb);
    }

    public static long divideConquer(int a, int b, int c) {
        if(b == 1) return a % c;

        if(b % 2 == 0){
            long num = divideConquer(a, b/2, c) % c;
            return (num * num) % c;
        }else {
            long num = divideConquer(a, (b-1)/2, c) % c;
            return ((num * num) % c) * a % c;
        }
    }

}

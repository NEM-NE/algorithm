package B1629;

import java.util.*;
import java.io.*;

public class Main {
    // 12:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = ps(a, b, c);

        sb.append(result);
        System.out.println(sb);
    }

    public static long ps(int a, int b, int c){
        if(b == 1){
            return a % c;
        }

        long num = 0;
        if(b % 2 == 0){
            num = ps(a, b/2, c) % c;
            return (num * num) % c;
        }else {
            num = ps(a, (b-1)/2, c) % c;
            return ((num * num) % c) * a % c;
        }
    }
}

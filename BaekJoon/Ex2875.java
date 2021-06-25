package BaekJoon;

import java.io.*;
import java.util.*;

public class Main{
	// 10 : 57
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        while(n >= 2 && m >= 1) {
        	n -= 2;
        	m -= 1;
        	cnt++;
        }
        
        k -= n;
        k -= m;
        while(k > 0) {
        	k -= 3;
        	cnt--;
        }
        
        sb.append(cnt);
        System.out.println(sb);
    }
}

package BaekJoon;

import java.io.*;
import java.util.*;

public class Main{
	// 10 : 47
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
        	ary[i] = Integer.parseInt(br.readLine());
        }
        
        int index = n-1;
        while(k != 0) {
        	if(ary[index] <= k) {
        		k -= ary[index];
        		cnt++;
        	}else index--;
        }
        
        sb.append(cnt);
        System.out.println(sb);
    }
}

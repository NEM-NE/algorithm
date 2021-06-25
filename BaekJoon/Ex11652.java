package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11652 {
	// 10 : 00
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		ArrayList<Long> ary = new ArrayList<Long>();
		for(int i = 0; i < tc; i++) {
			ary.add(Long.parseLong(br.readLine()));
		}
		
		Collections.sort(ary);
		
		int cnt = 1;
		int max = 1;
		long val = ary.get(0);
		
		for(int i = 1; i < tc; i++) {
			long cur = ary.get(i);
			long pre = ary.get(i-1);
			
			if(cur == pre) {
				cnt++;
			}else {
				cnt = 1;
			}
			
			if(max < cnt) {
				val = ary.get(i);
				max = cnt;
			}
		}
		
		sb.append(val);
		
		System.out.println(sb);
	}
}
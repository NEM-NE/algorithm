package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11004 {
	// 2 : 05
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Long> list = new ArrayList<Long>(n);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}
		
		Collections.sort(list);
		
		sb.append(list.get(k-1));
		System.out.println(sb);
		
	}
}
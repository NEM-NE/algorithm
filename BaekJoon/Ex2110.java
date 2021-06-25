package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2110 {
	// 10 : 20
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int house = Integer.parseInt(st.nextToken());
		int router = Integer.parseInt(st.nextToken()) - 1;
		list = new ArrayList<>();
		
		for(int i = 0; i < house; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		list.sort(null);
		
		int max = list.get(house-1);
		int min = 0;
		int ans = -1;
		while((min+1) < max) {
			int mid = (max + min) / 2;
			int len = list.get(0) + mid;
			int cnt = 0;
			
			for(int i = 1; i < list.size(); i++) {
				if(len <= list.get(i)) {
					len = list.get(i) + mid;
					cnt++;
				}
			}
			
			if(cnt < router) {
				max = mid;
			}else {
				min = mid;
				ans = mid;
			}
		}
		
		sb.append(ans);
		System.out.println(sb);
	}

}
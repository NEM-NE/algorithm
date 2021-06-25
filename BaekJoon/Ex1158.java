package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1158 {
	// 10 : 35
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		ArrayList ans = new ArrayList();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}

		int index = 0;
		while(list.size() != 0) {
			for(int i = 0; i < k-1; i++) {
				index++;
				if(index >= list.size()) index %= list.size();
			}
			ans.add(list.get(index));
			list.remove(index);
		}
		
		sb.append('<').append(ans.toString().substring(1, ans.toString().length()-1)).append('>');
		
		System.out.println(sb);
		
	}
}
package BaekJoon;

import java.io.*;
import java.util.*;

public class Exer11866Mysol {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			queue.offer(i+1);
		}
		int[] ans = new int[N];
		
		for(int i = 0; i < N; i++ ){
			int cnt = K-1;
			
			while(cnt-- > 0) {
				int temp = queue.poll();
				queue.offer(temp);
			}
			
			ans[i] = queue.poll();
		}
		
		String str = Arrays.toString(ans);
		str = "<" + str.substring(1, str.length()-1) + ">";
		sb.append(str);
		
		System.out.println(sb);
		
	}
}
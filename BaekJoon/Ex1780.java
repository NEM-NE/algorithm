package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1780 {
	// 6 : 43
	
	static int[][] ary;
	static int[] cnt;
	
	static void partition(int xStart, int yStart, int size) {
		boolean same = true;
		for(int i = yStart; i < yStart + size; i ++) {
			for(int j = xStart; j < xStart + size; j++) {
				if(ary[i][j] != ary[yStart][xStart]) {
					same = false;
				}
			}
		}
		
		if(!same) {
			int newSize = size/3;
			partition(xStart, yStart, newSize);
			partition(xStart + newSize, yStart, newSize);
			partition(xStart + 2 * newSize, yStart, newSize);
			
			partition(xStart, yStart + newSize, newSize);
			partition(xStart + newSize, yStart + newSize, newSize);
			partition(xStart + 2 * newSize, yStart + newSize, newSize);
			
			partition(xStart, yStart + 2 * newSize, newSize);
			partition(xStart + newSize, yStart + 2 * newSize, newSize);
			partition(xStart + 2 * newSize, yStart + 2 * newSize, newSize);
		}else {
			if(ary[yStart][xStart] == -1) cnt[0]++;
			else if(ary[yStart][xStart] == 0) cnt[1]++;
			else if(ary[yStart][xStart] == 1) cnt[2]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		ary = new int[tc+1][tc+1];
		cnt = new int[3];
		
		for(int i = 1 ; i <= tc; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= tc; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(1, 1, tc);
		
		sb.append(cnt[0]).append('\n');
		sb.append(cnt[1]).append('\n');
		sb.append(cnt[2]).append('\n');
		
		System.out.println(sb);
	}

}
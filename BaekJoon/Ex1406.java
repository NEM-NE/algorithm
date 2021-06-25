package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1406 {
	// 10 : 04
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> list = new LinkedList<>();
		
		String str = br.readLine();
		int tc = Integer.parseInt(br.readLine());

		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		ListIterator it = list.listIterator();
		
		while(it.hasNext()) {
			it.next();
		}
		
		for(int i = 0; i < tc; i++) {
			String stat = br.readLine();
			
			if(stat.charAt(0) == 'P') {
				it.add(stat.charAt(2));
			}else if(stat.charAt(0) =='L') {
				if(it.hasPrevious()) {
					it.previous();
				}
			}else if(stat.charAt(0) == 'D') {
				if(it.hasNext()) {
					it.next();
				}
			}else if(stat.charAt(0) == 'B') {
				if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
			}
		}
		
		while(list.size() != 0) {
			sb.append(list.pollFirst());
		}
		
		
		System.out.println(sb);
		
	}
}
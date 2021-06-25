package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1406sol2 {
	// 7 : 
	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int tc = Integer.parseInt(br.readLine());
		LinkedList<Character> list = new LinkedList<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		ListIterator it = list.listIterator();
		
		while(it.hasNext()) it.next();
		
		for(int i = 0; i < tc; i++) {
			String dir = br.readLine();
			
			if(dir.charAt(0) == 'P') {
				char input = dir.charAt(2);
				it.add(input);
			}else if(dir.charAt(0) == 'L') {
				if(it.hasPrevious()) {
					it.previous();
				}
			}else if(dir.charAt(0) == 'D') {
				if(it.hasNext()) it.next();
			}else if(dir.charAt(0) == 'B') {
				if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
			}
		}
		
		int num = list.size();
		
		for(int i = 0; i < num; i++) {
			sb.append(list.remove());
		}
		
		System.out.println(sb);
		
	}
}
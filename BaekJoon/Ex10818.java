package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10818 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();	
		int min = scanner.nextInt();
		int max = min;
		
		for(int i = 0; i < tc-1; i++) {
			int num = scanner.nextInt();
			
			if(max < num) max = num;
			if(min > num) min = num;
		}
		
		System.out.println(min + " " + max);

	}
}
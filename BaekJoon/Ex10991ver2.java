package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10991ver2 {
	// 10 : 27
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();

		for(int i = 0; i < tc; i++) {
			for(int j = tc-i-1; j > 0; j-- ) {
				System.out.print(" ");
			}
			
			for(int j = 0; j < i+1; j++) {
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}
}

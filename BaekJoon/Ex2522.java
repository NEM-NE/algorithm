package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2522 {
	// 10 : 58
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		for(int i = 0; i < tc; i++) {
			//up
			for(int j = 0; j < tc - i - 1; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < tc-1; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < tc-i-1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}

	}
}



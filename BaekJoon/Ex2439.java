package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2439 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		for(int i = 1; i <= tc; i++) {
			for(int j = tc-i; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}
}


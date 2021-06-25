package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2445 {
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		//up
		for(int i = 0; i < tc; i++) {
			//left
			for(int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			for(int k = tc-i-1; k > 0; k--) {
				System.out.print(" ");
			}
			
			//right
			for(int a = tc-i-1; a > 0; a--) {
				System.out.print(" ");
			}
			for(int b = 0; b < i+1; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//down
		for(int i = 0; i < tc-1; i++) {
			//left
			for(int j = tc-1-i; j > 0; j--) {
				System.out.print("*");
			}
			for(int k = 0; k < i+1; k++) {
				System.out.print(" ");
			}
			
			//right
			for(int a = 0; a < i+1; a++) {
				System.out.print(" ");
			}
			for(int b = tc-1-i; b > 0; b--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}



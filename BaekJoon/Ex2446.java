package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2446 {
	// 11 : 07
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		//up
		for(int i = 0; i < tc; i++) {
			//left
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < tc - i - 1; k++) {
				System.out.print("*");
			}
			
			//right
			for(int k = 0; k < tc - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//down
		for(int i = tc - 1; i > 0; i--) {
			//left
			for(int j = 0; j < i - 1; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < tc - i; k++) {
				System.out.print("*");
			}
			
			//mid
			System.out.print("*");
			
			//right
			for(int k = 0; k < tc - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}

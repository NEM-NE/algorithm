package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex10992 {
	// 10 : 33
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();

		for(int i = 0; i < tc; i++) {
			for(int j = tc-i-1; j > 0; j-- ) {
				System.out.print(" ");
			}
			
			if(i == tc-1) {
				for(int j = 0; j < 2*i+1; j++) {
					System.out.print("*");
				}
			}else if(i == 0){
				System.out.print("*");
			}else {
				System.out.print("*");
				for(int j = 0; j < 2 * i -1; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}

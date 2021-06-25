package BaekJoon;
import java.io.*;
import java.util.*;

public class Ex2442 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();

		for(int i = 0; i < tc; i++) {
			//left
			for(int j = tc-i-1; j > 0; j--) {
				System.out.print(" ");
			}
			for(int a = 0; a < i; a++) {
				System.out.print("*");
			}
			//right
			for(int k = 0; k < i+1; k++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}
}
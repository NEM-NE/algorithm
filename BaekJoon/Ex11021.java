package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11021 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		
		int tc = scanner.nextInt();
		
		for(int i = 0; i < tc; i++) {

			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int sum = a+b;
			System.out.println("Case #" + (i+1) + ": " + sum);
		}
	
	}
}
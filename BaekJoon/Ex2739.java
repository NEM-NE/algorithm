package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex2739 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int tc = scanner.nextInt();
		
		for(int i = 1; i < 10; i++) {
			int sum = tc * i;
			System.out.println(tc + " * " + i + " = " + sum);
		}
	}
}
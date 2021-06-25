package BaekJoon;
import java.io.*;
import java.util.*;

public class Ex11720 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		
		int tc = scanner.nextInt();
		String str = scanner.next();
		int sum = 0;
		
		for(int i = 0; i < tc; i++) {
			int a = (int)str.charAt(i) - 48;
			sum += a;
		}
		
		System.out.println(sum);
	
	}
}

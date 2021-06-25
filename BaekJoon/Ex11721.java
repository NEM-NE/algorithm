package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex11721 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		int beginIn = 0;
		int endIn = 10;
		
		while(true) {
			
			if(endIn > str.length()) {
				System.out.println(str.substring(beginIn, str.length()));
				break;
			}
			
			System.out.println(str.substring(beginIn, endIn));
			
			beginIn = endIn;
			endIn += 10; 
		}
	}
}
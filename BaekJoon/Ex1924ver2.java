package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1924ver2 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int month = scanner.nextInt();
		int day = scanner.nextInt();
		
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int i = 1; i < month; i++) {
			day += months[i];
		}
		
		day %= 7;
		
		if(day == 0) {
			System.out.println("SUN");
		}else if(day == 1) {
			System.out.println("MON");
		}else if(day == 2) {
			System.out.println("TUE");
		}else if(day == 3) {
			System.out.println("WED");
		}else if(day == 4) {
			System.out.println("THU");
		}else if(day == 5) {
			System.out.println("FRI");
		}else if(day == 6) {
			System.out.println("SAT");
		}
		

	}
}

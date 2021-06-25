package BaekJoon;

import java.io.*;
import java.util.*;

public class Ex1924 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);

		int month = scanner.nextInt();
		int day = scanner.nextInt();
		
		for(int i = 1; i < month; i++) {
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				day += 31;
			}else if(i == 2){
				day += 28;
			}else {
				day += 30;
			}
		}
		day %= 7;

		if(day == 1) {
			System.out.println("MON");
		}if(day == 2) {
			System.out.println("TUE");
		}if(day == 3) {
			System.out.println("WED");
		}if(day == 4) {
			System.out.println("THU");
		}if(day == 5) {
			System.out.println("FRI");
		}if(day == 6) {
			System.out.println("SAT");
		}if(day == 0) {
			System.out.println("SUN");
		}
		
	}
}
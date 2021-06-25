package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Exer4949 {
	
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			while(scanner.hasNextLine()) {
				String str = scanner.nextLine();
				if(!str.contains(".") || str.equals(".")) { break; }
		
				char[] charAry = str.toCharArray();	
				char[] stack = new char[charAry.length];
				int index = 0;
				boolean flag = true;
				
				for(int i = 0; i < charAry.length; i++) {
					if(charAry[i] == '(') {
						stack[index] = '(';
						index++;
					}else if(charAry[i] == '[') {
						stack[index] = '[';
						index++;
					}else if(charAry[i] == ')') {
						if(index == 0 || stack[index-1] != '(' ) {
							flag = false;
						}else stack[--index] = '0';
					}else if(charAry[i] == ']') {
						if(index == 0 || stack[index-1] != '[') {
							flag = false;
						}else stack[--index] = '0';
					}
				}
				
				if(index != 0) flag = false;
				
				if(flag) bw.write("yes" + "\n");
				else bw.write("no" + "\n");
				bw.flush();
			}
			bw.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

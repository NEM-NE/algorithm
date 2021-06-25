import java.util.*;
import java.io.*;

public class Ex2447 {
	// 04 : 25
	
	static char[][] output;
	
	static void drwaBlank(int size, int xStart, int yStart) {
		for(int j = yStart; j < yStart + size; j++) {
			for(int i = xStart; i < xStart + size; i++) {
				output[j][i] = ' ';
			}	
		}
	}
	
	static void partition(int size, int xStart, int yStart) {
		if(size == 3) {
			
			output[yStart][xStart] = '*';
			output[yStart][xStart + 1] = '*';
			output[yStart][xStart + 2] = '*';
			
			output[yStart + 1][xStart] = '*';
			output[yStart + 1][xStart + 1] = ' ';
			output[yStart + 1][xStart + 2] = '*';
			
			output[yStart + 2][xStart] = '*';
			output[yStart + 2][xStart + 1] = '*';
			output[yStart + 2][xStart + 2] = '*';
			
			return;
		}
		
		int newSize = size/3;
		
		partition(newSize, xStart, yStart);
		partition(newSize, xStart + newSize, yStart);
		partition(newSize, xStart + 2 * newSize, yStart);
		
		partition(newSize, xStart, yStart + newSize);
		drwaBlank(newSize, xStart + newSize, yStart + newSize);
		partition(newSize, xStart + 2 * newSize, yStart + newSize);
		
		partition(newSize, xStart, yStart + 2 * newSize);
		partition(newSize, xStart + newSize, yStart + 2 * newSize);
		partition(newSize, xStart + 2 * newSize, yStart + 2 * newSize);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		output = new char[tc][tc];
		
		partition(tc, 0, 0);
		
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[0].length; j++) {
				sb.append(output[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}

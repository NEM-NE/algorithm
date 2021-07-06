import java.io.*;
import java.util.*;


public class Main {
	
	// 11 : 25 81
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		// 1개만 주워졌을 경
		if(n == 1) {
			System.out.println(br.readLine());
			return;
		}
		
		ArrayList<Integer> nega = new ArrayList<Integer>();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean isEven = true;
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num < 0) {
				nega.add(num);
			}else if(num > 0) {
				pos.add(num);
			}else {
				if(!list.contains(0)) list.add(num);
			}
		}
		
		Collections.sort(nega);
		Collections.sort(pos);
		
		if(nega.size() % 2 != 0) {
			isEven = false;
			list.add(nega.get(nega.size() - 1));
			nega.remove(nega.size() - 1);
		}
		
		if(pos.size() % 2 != 0) {
			isEven = false;
			list.add(pos.get(0));
			pos.remove(0);
		}
		
		Collections.sort(list);
		
		int sum = 0;
		
		for(int i = 0; i <nega.size()-1; i+=2) {
			sum += nega.get(i) * nega.get(i+1);
		}
		
		for(int i = pos.size() - 1; i > 0; i-=2) {
			int a = pos.get(i);
			int b = pos.get(i-1);
			
			if(b == 1) {
				sum += a + b;
			}else sum += a * b;
		}
		
		if(!isEven) {
			if(list.size() == 1) {
				sum += list.get(0);
			}else if(list.size() == 2){
				int first = list.get(0);
				int second = list.get(1);
				
				if((first < 0 && second > 0) || first == 0) {
					sum += first + second;
				}
				
			}else {
				sum += list.get(0) * list.get(1) + list.get(2);
			}
		}
		
		
		sb.append(sum);
		System.out.println(sb);
		
		
	}

}

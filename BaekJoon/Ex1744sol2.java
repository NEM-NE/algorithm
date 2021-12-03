import java.io.*;
import java.util.*;


public class Ex1744sol2 {
	
	// 5 : 53 20
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> pos = new ArrayList<Integer>();
		ArrayList<Integer> nega = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num < 0) {	//negative
				nega.add(num);
			}else if(num > 0) { //positive
				pos.add(num);
			}else if(!list.contains(0))list.add(num); // 0
		}
		
		//	오름차순 정
		Collections.sort(pos);
		Collections.sort(nega);
		
		// 홀수일 경우 삭
		if(pos.size() % 2 != 0) {	
			list.add(pos.get(0));
			pos.remove(0);
		}
		
		if(nega.size() % 2 != 0) {
			list.add(nega.get(nega.size()-1));
			nega.remove(nega.size() - 1);
		}
		
		Collections.sort(list);
		
		for(int i = pos.size()-1; i > 0; i-=2) {
			// 1, 3일 경우 곱하는 게 손해
			if(pos.get(i-1) == 1) {
				sum += pos.get(i) + pos.get(i-1);	
				continue;
			} 
			sum += pos.get(i) * pos.get(i-1);
		}
		
		for(int i = 0; i < nega.size()-1; i+=2) {
			sum += nega.get(i) * nega.get(i+1);
		}
		
		if(list.size() == 1) {
			sum += list.get(0);
		}else if(list.size() == 2) {
			int a = list.get(0);
			int b = list.get(1);
			
			if(a < 0 && b > 0) {
				sum += a + b;
			}else if(a == 0) sum += b;
		}else if(list.size() == 3) sum += list.get(2);
		
		sb.append(sum);
		System.out.println(sb);
		
		
	}

}

import java.io.*;
import java.util.*;


public class Ex1107sol2 {
	
	static ArrayList<Integer> list;
	
	static int cal(int channel) {
		int cnt = 0;
		
		if(channel == 0) {
			if(list.contains(0)) return -1;
			return 1;
		}
		
		while(channel > 0) {
			int num = channel % 10;
			
			if(list.contains(num)) return -1;
			
			cnt++;
			channel /= 10;
		}
		
		return cnt;
	}
	
	// 2 : 35 14min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int channel = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());
		list = new ArrayList<Integer>();
		int min = Math.abs(channel - 100);
	
		if(size > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}	
		}
		
		for(int i = 0; i <= 1000000; i++) {
			
			int num = cal(i);
			
			if(num == -1) continue;
			
			min = Math.min(min, Math.abs(channel - i) + num);
		}
		
		sb.append(min);
		System.out.println(sb);
	}

}

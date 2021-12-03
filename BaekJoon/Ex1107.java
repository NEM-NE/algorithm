import java.io.*;
import java.util.*;


public class Ex1107 {
	
	static int cal(ArrayList<Integer> list, int channel, int cnt) {
	
		if(channel == 0) {
			if(list.contains(0)) return -1; 
			return 1;
		}
		
		while(channel > 0) {
			int num = channel % 10;
			
			// 고장난 버튼일 경우
			if(list.contains(num)) return -1; 
			
			cnt++;
			channel /= 10;
		}
		
		return cnt;
	}
	
	// 11 : 18  22min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int channel = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if(size > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int min = Math.abs(channel - 100);
		
		for(int i = 0; i < 1000000; i++) {
			int num = cal(list, i, 0);
			
			if(num != -1) {
				min = Math.min(min, num + Math.abs(channel - i));
			}
		}
		
		sb.append(min);
		System.out.println(sb);
		
	}

}

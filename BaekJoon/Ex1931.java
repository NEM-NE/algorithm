import java.util.*;
import java.io.*;


public class Main {
	
	// 11 : 30
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());
		
		int[][] list = new int[size][2];
		
		// input
		for(int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {	// 끝나는 시간이 같을 떄
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		
		int cnt = 0;
		int pre = 0;
		
		for(int i = 0; i < size; i++) {
			if(pre <= list[i][0]) {
				cnt++;
				pre = list[i][1];
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
		
		
	}

}

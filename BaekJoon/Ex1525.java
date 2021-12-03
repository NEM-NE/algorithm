import java.io.*;
import java.util.*;


public class Ex1525 {
	
	static HashMap<String, Integer> map;
	static int[][] ary;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void bfs(String start) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			String str = queue.poll();
			
			int index = str.indexOf("0");
			int x = index % 3;
			int y = index / 3;
			
			for(int i = 0; i < 4; i++) {
				StringBuilder sb = new StringBuilder(str);
				
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= 3 || yy < 0 || yy >= 3) continue;
				
				int newIndex = xx + yy * 3;
				
				char temp = str.charAt(newIndex);
				
				sb.setCharAt(newIndex, str.charAt(index));
				sb.setCharAt(index, temp);
				
				if(sb.toString().equals("123456780")) {
					map.put(sb.toString(), map.get(str) + 1);
					return;
				}
				
				if(!map.containsKey(sb.toString())) {
					map.put(sb.toString(), map.get(str) + 1);
					queue.offer(sb.toString());
				}
				
			}
			
		}
		
		
	}
	
	// 09 : 49 54min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		map = new HashMap<String, Integer>();
		ary = new int[3][3];
		
		String start = "";
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				int num = Integer.parseInt(st.nextToken());
				ary[i][j] = num;
				start += num;
			}
		}
		
		map.put(start, 0);
		map.put("123456780", -1);
		
		if(start.equals("123456780")) map.put("123456780", 0);
		else bfs(start);
		
		sb.append(map.get("123456780"));
		
		System.out.println(sb);
	}

}

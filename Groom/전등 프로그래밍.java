import java.io.*;
import java.util.*;
class Main1 {
	// 12:19
    // tc에서 런타임 오류나긴 하는데 잘못 채점된듯?
	static boolean[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		// input Data
		map = new boolean[y+1][x+1];
		for(int i = 1; i <= y; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= x; j++){
				map[i][j] = st.nextToken().equals("1") ? true : false;
			}
		}
		
		//ps solve
		int tc = Integer.parseInt(br.readLine());
		while(tc != 0){
			st = new StringTokenizer(br.readLine());
			boolean isWidth = st.nextToken().equals("0") ? true : false;
			int lineNum = Integer.parseInt(st.nextToken());
			
			if(isWidth){
				for(int i = 1; i <= x; i++){
					map[lineNum][i] = !map[lineNum][i];
				}
			}else {
				for(int i = 1; i <= y; i++){
					map[i][lineNum] = !map[i][lineNum];
				}
			}
			
			tc--;
		}
		
		// print result
		for(int i = 1; i <= y; i++){
			for(int j = 1; j <= x; j++){
				int result = map[i][j] ? 1 : 0;
				sb.append(result).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;


public class Ex1931sol2 {

	static class Node {
		int start, end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	// 9 : 50 35min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Node[] conference = new Node[n];
		StringTokenizer st = null;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			conference[i] = new Node(start, end);
		}
		
		Arrays.sort(conference, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}
				
				return o1.end - o2.end;
			}
		});
		
		int cnt = 1;
		int index = 1;
		int cur = conference[0].end;
		while(index != n) {		
			
			if(cur > conference[index].start) {
				index++;
				continue;
			}
			
			cur = conference[index].end;
			index++;
			cnt++;
		}
		
		sb.append(cnt);
		System.out.println(cnt);
	}

}

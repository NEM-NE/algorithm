import java.io.*;
import java.util.*;


public class Main {
	
	static class Bucket{
		int A, B, C;
		
		public Bucket() {
			this.C = 0;
			this.A = 0;
			this.B = 0;
		}
	}
	
	static int a, b, c;
	static HashMap<String, Integer> map;
	static ArrayList<Integer> cBucket;
	
	static void bfs() {
		Queue<Bucket> queue = new LinkedList<Bucket>();
		Bucket cur = new Bucket();
		cur.C = c;
		
		queue.add(cur);
		
		while(!queue.isEmpty()) {
			Bucket bucket = queue.poll();
			
			if(map.containsKey("" + bucket.A + bucket.B + bucket.C)) {
				continue;
			}
			
			if(bucket.A == 0) {
				cBucket.add(bucket.C);
			}
			
			map.put("" + bucket.A + bucket.B + bucket.C, bucket.C);
			
			Bucket temp;
			
			// case A
			if(bucket.A != 0) {
				// case to B
				temp = new Bucket();
				temp.B = (bucket.B + bucket.A > b) ? b : bucket.B + bucket.A;
				temp.A = (temp.B == bucket.B + bucket.A) ? 0 : bucket.A - (temp.B - bucket.B);
				temp.C = bucket.C;
				queue.offer(temp);
				
				// case to C
				temp = new Bucket();
				temp.C = (bucket.C + bucket.A > c) ? c : bucket.C + bucket.A;
				temp.A = (temp.C - bucket.C == bucket.A) ? 0 : bucket.A - (temp.C - bucket.C);
				temp.B = bucket.B;
				
				queue.offer(temp);
			}
			
			// case B
			if(bucket.B != 0) {
				// case to A
				temp = new Bucket();
				temp.A = (bucket.A + bucket.B > a) ? a : bucket.A + bucket.B;
				temp.B = (temp.A - bucket.A == bucket.B) ? 0 : bucket.B - (temp.A - bucket.A);
				temp.C = bucket.C;
				queue.offer(temp);
				
				// case to C
				temp = new Bucket();
				temp.C = (bucket.C + bucket.B > c) ? c : bucket.C + bucket.B;
				temp.B = (temp.C - bucket.C == bucket.B) ? 0 : bucket.B - (temp.C - bucket.C);
				temp.A = bucket.A;
				
				queue.offer(temp);
			}
			
			// case C
			if(bucket.C != 0) {
				// case to A
				temp = new Bucket();
				temp.A = (bucket.A + bucket.C > a) ? a : bucket.A + bucket.C;
				temp.C = (temp.A - bucket.A == bucket.C) ? 0 : bucket.C - (temp.A - bucket.A);
				temp.B = bucket.B;
				
				queue.offer(temp);
				
				// case to B
				temp = new Bucket();
				temp.B = (bucket.B + bucket.C > b) ? b : bucket.B + bucket.C;
				temp.C = (temp.B - bucket.B == bucket.C) ? 0 : bucket.C - (temp.B - bucket.B);
				temp.A = bucket.A;
				
				queue.offer(temp);
			}
			
		}
	}
	
	// 04 : 02 52min
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new HashMap<String, Integer>();
		cBucket = new ArrayList<Integer>();
		
		bfs();
		
		Collections.sort(cBucket);
		
		for(int i = 0; i < cBucket.size(); i++) {
			sb.append(cBucket.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}

}

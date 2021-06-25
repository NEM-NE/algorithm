import java.io.*;
import java.util.*;

public class Main{
	// 8 : 01
	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point[] ary;
	
	static int getDist(Point a, Point b) {
		return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
	}
	
	static int bruteForce(int start, int end) {
		int min = Integer.MAX_VALUE;
		
		for(int i = start; i <= end; i++) {
			for(int j = start; j < i; j++) {
				min = Math.min(min, getDist(ary[i], ary[j]));
			}
			
		}
		
		return min;
	}
	
	static int closetPair(Point[] ary, int start, int end) {
		if((end - start) <= 2) {
			return bruteForce(start, end);
		}
		
		int mid = (start + end) / 2;
		int dist = Math.min(closetPair(ary, start, mid), closetPair(ary, mid+1, end));
		
		ArrayList<Point> band = new ArrayList<Point>();
		for(int i = start; i <= end; i++) {		
			int temp = ary[mid].x - ary[i].x;
				
			if(temp * temp < dist) band.add(ary[i]);
		}
		
		Collections.sort(band, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		
		for(int i = 0; i < band.size() - 1; i++) {
			for(int j = i+1; j < band.size(); j++) {
				int temp = band.get(i).y - band.get(j).y;
				
				if(temp * temp < dist) dist = Math.min(dist, getDist(band.get(i), band.get(j)));
				else break;
			}
		}
		
		return dist;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        ary = new Point[tc];
        
        for(int i = 0; i < tc; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	ary[i] = new Point(x, y);
        }
        
        Arrays.sort(ary, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.x - o2.x;
			}
        	
		});
        
        int ans = closetPair(ary, 0, tc - 1);
        
        sb.append(ans);
        
        System.out.println(sb);
    }
}

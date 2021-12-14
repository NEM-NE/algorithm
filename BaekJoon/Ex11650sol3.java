import java.io.*;
import java.util.*;

public class Ex11650sol3 {
	// 11 : 41	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
        int tc = Integer.parseInt(br.readLine());
        LinkedList<Point> pointList = new LinkedList<Point>();
		for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point point = new Point(x, y);

            pointList.add(point);
        }

        Collections.sort(pointList);

        for(int i = 0; i < tc; i++){
            Point point = pointList.poll();

            sb.append(point.toString()).append("\n");
        }

        System.out.println(sb);

	}

    static class Point implements Comparable<Point>{
        private int x;
        private int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other){
            if(other.x != this.x){
                return this.x - other.x;
            }
            
            return this.y - other.y;
        }

        public String toString(){
            return this.x + " " + this.y;
        }
    }
	
}
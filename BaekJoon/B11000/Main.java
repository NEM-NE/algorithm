package B11000;

import java.util.*;
import java.io.*;

public class Main {
    // 10:25
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Lecture {
        int start, end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        Lecture[] list = new Lecture[tc];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[i] = new Lecture(s, t);
        }

        Arrays.sort(list, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        pq.offer(list[0].end);
        for(int i = 1; i < list.length; i++){
            if(pq.peek() <= list[i].start) {
                pq.poll();
            }

            pq.offer(list[i].end);
        }

        sb.append(pq.size());
        System.out.println(sb);

    }
}

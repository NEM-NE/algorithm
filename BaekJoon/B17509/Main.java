package B17509;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Node {
        int time, incorrectCnt;

        public Node(int time, int incorrectCnt){
            this.time = time;
            this.incorrectCnt = incorrectCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.time == o2.time){
                return o2.incorrectCnt - o1.incorrectCnt;
            }

            return o1.time - o2.time;
        });

        for(int i = 0; i < 11; i++){
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.offer(new Node(d, v));
        }

        int sum = 0;
        int time = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();

            time += node.time;

            sum += time + (20 * node.incorrectCnt);
        }

        sb.append(sum);
        System.out.println(sb);
    }
}

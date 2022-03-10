package 단속카메라;

import java.util.*;

public class Solution {
    static PriorityQueue<Node> pq;
    static class Node {
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] routes) {
        pq = new PriorityQueue<Node>((o1, o2) -> o1.y - o2.y);

        for(int[] route : routes){
            pq.offer(new Node(route[0], route[1]));
        }

        int camera = Integer.MIN_VALUE;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(camera >= cur.x && camera <= cur.y){
                continue;
            }

            camera = cur.y;
            cnt++;
        }

        return cnt;
    }
}

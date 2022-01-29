package 더맵게;

import java.util.*;

class Solution {
    //04:24 14분
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int ans = 0;        
        int scov = pq.peek();
        while(pq.size() > 1 && scov < K){
            int a = pq.poll();
            int b = pq.poll();

            a += b * 2;
            
            pq.offer(a);
            
            scov = pq.peek();
            ans++;
        }
        
        return (scov < K) ? -1 : ans;
    }
}

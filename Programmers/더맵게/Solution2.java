package 더맵게;

import java.util.*;

import java.util.*;

class Solution2 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for(long num : scoville) {
            pq.offer(num);
        }

        int cnt = 0;
        while(true){
            if(pq.size() == 0) {
                cnt = -1;
                break;
            }else if(pq.peek() >= K) break;
            else if(pq.size() == 1) {
                cnt = -1;
                break;
            }

            long first = pq.poll();
            long second = pq.poll();

            long newScoville = first + (second * 2);

            pq.offer(newScoville);
            cnt++;
        }

        return cnt;
    }
}

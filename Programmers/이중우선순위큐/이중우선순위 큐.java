package 이중우선순위큐;

import java.util.*;

class Solution {
    // 10 : 20 14분
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxPq = 
                new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++){
            String str = operations[i];
            char oper = str.charAt(0);
            int num = Integer.parseInt(str.substring(2, str.length()));
            
            if(oper == 'I'){    // add value
                minPq.offer(num);
                maxPq.offer(num);
            }else if(oper == 'D' && num == 1 && minPq.size() > 0){//  remove max
                int temp = maxPq.poll();
                minPq.remove(temp);
            }else if(oper == 'D' && num == -1 && minPq.size() > 0){ //  remove min
                int temp = minPq.poll();
                maxPq.remove(temp);
            }
        }
        
        int[] ans = new int[2];
        
        if(maxPq.size() == 0 && minPq.size() == 0){
            ans[0] = 0;
            ans[1] = 0;
        }else{
            ans[0] = maxPq.poll();
            ans[1] = minPq.poll();
        }
        
        return ans;

    }
}

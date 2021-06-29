import java.util.*;

class Solution {
    // 11 : 18 40분
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];      // 정답 배열
        
        for(int i = 0; i < prices.length; i++){
            int num = prices[i];
            int cnt = 0;
            
            for(int j = i+1; j < prices.length; j++){
                cnt++;
                if(num > prices[j]) break;
            }
            
            answer[i] = cnt;
            
        }
        
        return answer;
    }
}

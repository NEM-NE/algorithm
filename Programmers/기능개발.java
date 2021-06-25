import java.util.*;

class Solution {
    // 11 : 03 18분
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int index = 0;
        while(index < progresses.length){
            int cnt = 0;
            
            // 진행률이 100이 넘었는지 앞에서부터 확인 만약 넘었다면 index값을 땡긴다. 
            for(int i = index; i < progresses.length; i++){
                if(progresses[i] >= 100) {
                    index++;
                    cnt++;
                }else break;
            }
            
            // 진행률이 100 미만인 곳은 개발 속도에 따라 값을 더해준다.
            for(int i = index; i < progresses.length; i++){
                   progresses[i] += speeds[i];
            }
            
            if(cnt > 0)list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

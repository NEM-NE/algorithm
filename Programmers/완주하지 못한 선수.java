import java.util.*;

class Solution {
    // 02 : 39
    
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < participant.length; i++){
            if(map.get(participant[i]) == null){
                map.put(participant[i], 1);
            }else{
                int val = map.get(participant[i]);
                map.put(participant[i], val+1);
            }
        }
        
        for(int i = 0; i < completion.length; i++){
            int val = map.get(completion[i]);
            map.put(completion[i], val - 1);
        }
        
        String ans = "";
       for(int i = 0; i < participant.length; i++){
            if(map.get(participant[i]) != 0){
                ans = participant[i];
                break;
            }
        
        }
        
        return ans;
        
    }
}

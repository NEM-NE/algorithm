import java.util.*;

class Solution {
    //09 : 33
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int ans = 1;
        
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
            ans *= (Integer)entry.getValue() + 1;
        }
        ans--;
        
        return ans;
    }
}

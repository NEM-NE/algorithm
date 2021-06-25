import java.util.*;

class Solution {
    // 11 : 29 34분 85점
    
    static Queue<String> que;
    
    static boolean dataSearch(String str, int size){
        int cnt = 1;
        if(que.size() < size) size = que.size();
        while(cnt <= size){
            String temp = que.poll();
            
            if(str.equals(temp)) return true;
            
            que.offer(temp);
            cnt++;
        }
        
        return false;
    }
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        que = new LinkedList<String>();
        
        int index = 0;
        while(index < cities.length){
            String str = cities[index].toLowerCase();
            boolean flag = dataSearch(str, cacheSize);
            
            if(que.size() == cacheSize) que.poll();
            
            if(que.size() < cacheSize){
                que.offer(str);
                if(flag) answer++;
                else answer += 5;
            }else{
                if(flag){
                    que.offer(str);
                    answer++;
                }else answer += 5;
            }
            
            index++;
        }
        
        return answer;
    }
}

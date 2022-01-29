package 프린터;

import java.util.*;

class Solution {
    //08 : 09 23min
    
    public int solution(int[] priorities, int location) {
        Queue<Integer> que = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int cnt = 1;
        
        // 데이터 삽입
        for(int i = 0; i < priorities.length; i++){
            que.offer(priorities[i]);
            list.add(priorities[i]);
        }
        
        // 최대값 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        while(location != -1){
            // 현재 최하단에 위치
            int temp = que.poll();
            System.out.println(temp);
            if(temp == list.get(0)){
                if(location == 0) {
                    break;
                }

                list.remove(0);
                cnt++;
            }else{
                que.offer(temp);
            }
            
            location = (location == 0) ? que.size() - 1 : location-1;
        }
        
        return cnt;
    }
}

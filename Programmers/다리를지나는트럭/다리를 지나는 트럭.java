package 다리를지나는트럭;

import java.util.*;

class Solution {
    // 07 : 12 33min
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<Integer>();
        int index = 0;
        int sum = 0;
        int cnt = 0;
        
        while(index < truck_weights.length){
            if(bridge.isEmpty()){
                bridge.offer(truck_weights[index]);
                sum += truck_weights[index++];
                cnt++;
            }else if(bridge.size() == bridge_length){
                sum -= bridge.poll();
            }else{
                if(sum + truck_weights[index] <= weight){
                    bridge.offer(truck_weights[index]);
                    sum += truck_weights[index++];
                }else{
                    bridge.offer(0);
                }
                
                cnt++;
            }    
        }
        
        return cnt + bridge_length;
    }
}

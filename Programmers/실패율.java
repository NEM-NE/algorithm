import java.util.*;

class Solution {
    //06 : 01 39분
    
    static class Stage {
        int num;
        float fault;
        
        public Stage(int num, float fault){
            this.num = num;
            this.fault = fault;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        ArrayList<Stage> list = new ArrayList<Stage>();
        Arrays.sort(stages);
        
        int index = 0;     
        for(int k = 1; k <= N; k++){
            int cnt = 0;
            int start = index;
            
            for(int i = index; i < stages.length; i++){
                if(stages[i] != k) {
                    index = i;
                    break;
                }
                cnt++;
            }
            
            float fault = (float) cnt / (stages.length - start);
            list.add(new Stage(k, fault));  
        }
        
        
        Collections.sort(list, new Comparator<Stage>(){
            public int compare(Stage o1, Stage o2){
                if(o1.fault == o2.fault){
                    return o1.num - o2.num;
                }else{
                    return (o2.fault > o1.fault) ? 1 : -1;
                }
            }
        });
        
        int[] ans = new int[N];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i).num;
        }
        
        return ans;
    }
}

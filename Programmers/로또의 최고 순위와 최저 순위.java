// 1:58
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rankingAry = {6, 6, 5, 4, 3, 2, 1};
        
        int cnt = 0;
        int zeroCnt = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]) cnt++;
            }
        }
        
        int[] answer = {rankingAry[cnt+zeroCnt], rankingAry[cnt]};
        return answer;
    }
}
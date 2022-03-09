package 구명보트;

public class Solution2 {
    static int[] weights;
    public int solution(int[] people, int limit) {
        int cnt = 0;
        weights = new int[201];

        for(int weight : people){
            weights[weight-40]++;
        }

        for(int i = 0; i < weights.length; i++){
            while(weights[i] > 0) {
                weights[i]--;
                cnt++;

                for(int j = limit - (i + 40) - 40; j >= 0; j--){
                    if(weights[j] > 0){
                        weights[j]--;
                        break;
                    }
                }
            }
        }

        return cnt;
    }
}

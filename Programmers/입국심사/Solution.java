package 입국심사;

import java.util.*;

public class Solution {
    static long N;
    static long[] TIMES;
    public long solution(int n, int[] times) {
        N = n;
        TIMES = new long[times.length];

        for(int i = 0; i < times.length; i++){
            TIMES[i] = (long)times[i];
        }
        Arrays.sort(TIMES);

        long max = TIMES[TIMES.length-1] * n;
        long min = 1;

        long result = TIMES[0] * N;

        while(max > min + 1){
            long mid = (max + min) / 2;

            long cnt = 0;
            for(long time : TIMES){
                cnt += mid / time;
            }

            if(cnt >= N){
                max = mid;
                result = Math.min(result, mid);
            }else {
                min = mid;
            }
        }

        return result;

    }
}

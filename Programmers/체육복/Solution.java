package 체육복;

import java.util.*;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] redundancy = new boolean[n+1];
        int lostSize = lost.length;

        for(int i = 0; i < reserve.length; i++){
            redundancy[reserve[i]] = true;
        }

        //여벌이 있지만 도난 당한 경우 빼기
        for(int i = 0; i < lost.length; i++){
            if(redundancy[lost[i]]) {
                redundancy[lost[i]] = false;
                lostSize--;
                lost[i] = -1;
            }
        }

        Arrays.sort(lost);

        //여벌 빌려주기
        for(int i = 0; i < lost.length; i++){
            int idx = lost[i]-1;
            int idx2 = lost[i]+1;

            if(idx < 0 || idx2 > n) continue;


            if(redundancy[idx]){
                redundancy[idx] = false;
                lostSize--;
            }else if(redundancy[idx2]){
                redundancy[idx2] = false;
                lostSize--;
            }
        }

        return n - lostSize;
    }
}

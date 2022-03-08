package 구명보트;

import java.util.*;

class Solution {
    static int[] ary = new int[201];

    public int solution(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);

        for(int i = 0; i < people.length; i++){
            ary[people[i] - 40]++;
        }


        for(int i = 0; i < ary.length; i++){
            while(ary[i] != 0){

                ary[i]--;
                result++;

                if(limit - i - 80 < 0) continue;
                for(int j = limit - i - 80; j >= 0; j--){
                    if(ary[j] > 0){
                        ary[j]--;
                        break;
                    }
                }

            }
        }

        return result;
    }
}
package 소수찾기;

import java.util.*;

class Solution {
    //41min
    static boolean[] isNotPrime = new boolean[10000000];
    static Set<Integer> set = new HashSet<Integer>();
    public int solution(String numbers) {
        // 소수 찾기
        setPrimeAry();

        // 모든 숫자 구하기
        for(int i = 0; i < numbers.length(); i++){
            getNumbers(String.valueOf(numbers.charAt(i)), numbers.substring(0, i) + numbers.substring(i+1, numbers.length()));
        }

        int answer = 0;

        for(int num : set){
            System.out.println(num);
            if(!isNotPrime[num]) {
                answer++;
            }
        }


        return answer;
    }

    private static void setPrimeAry() {
        for(int i = 2; i < isNotPrime.length; i++){
            for(int j = i + i; j < isNotPrime.length; j+=i){
                isNotPrime[j] = true;
            }
        }

        isNotPrime[0] = true;
        isNotPrime[1] = true;
    }

    private static void getNumbers(String str, String str2){
        set.add(Integer.valueOf(str));

        if(str2.length() == 1){
            getNumbers(str + str2.substring(0, 1), "");
        }else {
            for(int i = 0; i < str2.length(); i++){
                getNumbers(str + str2.substring(i, i+1), str2.substring(0, i) + str2.substring(i+1, str2.length()));
            }
        }
    }
}

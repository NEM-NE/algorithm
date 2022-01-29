package 가장큰수;

import java.util.*;

class Solution2 {
    // 12 : 27 37
    public String solution(int[] numbers) {
        
        Integer b[] = Arrays.stream(numbers).boxed().toArray(Integer[]::new); 
        Arrays.sort(b, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                String str1 = o1 + "";
                String str2 = o2 + "";
                
                int a = Integer.parseInt(str1 + str2);
                int b = Integer.parseInt(str2 + str1);
                
                return b - a;
            }
        });
        
        String ans = "";

        for(int i = 0; i < b.length; i++){
            if(ans.equals("") && b[i] == 0) return "0";
            ans += b[i];
        }

        return ans;
    }
}

package 신규아이디추천;

import java.util.*;

class Solution {
    //12 : 10 32분
    public String solution(String new_id) {
        //step 1
        String str = new_id.toLowerCase();
        
        // step 2
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            
            if((cur >= 'a' && cur <= 'z') 
               || (cur >= '0' && cur <= '9') || cur == '-' 
               || cur == '_' || cur =='.'){
                list.add(cur);
            }
        }
        
        //step3
        for(int i = list.size() - 1; i > 0; i--){
            char cur = list.get(i);
            char pre = list.get(i-1);
            
            if(cur == '.' && pre == '.'){
                list.remove(i);
            }
        }
        
        //step4
        if(list.size() > 0 && list.get(0) == '.'){
            list.remove(0);
        }
        if(list.size() > 0 && list.get(list.size() - 1) == '.'){
            list.remove(list.size() - 1);
        }
        
        //step5
        if(list.size() == 0) list.add('a');
        
        //step6
        while(list.size() >= 16){
            list.remove(15);
        }
        
        while(list.get(list.size() - 1) == '.'){
            list.remove(list.size() - 1);
        }
        
        //step7
        if(list.size() <= 2){
            char last = list.get(list.size() - 1);
            while(list.size() != 3){
                list.add(last);
            }
        }
        
        String ans = "";
        for(int i = 0; i < list.size(); i++){
            ans += list.get(i);
        }
        
        return ans;
    }
}

import java.util.*;

class Solution {
    // 08 : 54
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<String>();
        
        for(int i = 0; i < phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){    // <=phone_book[i].length(); 하면 틀림! 분해한 단어도 탐색하기 때문..!
                String str = phone_book[i].substring(0, j);
                if(set.contains(str)){
                    return false;
                }
            }
        }
        
        return true;
    }
}

package 모음사전;

public class Solution {
    static String[] inputs = {"A", "E", "I", "O", "U"};
    static int cnt;
    static int answer;

    public int solution(String word) {
        cnt = 0;
        answer = 0;
        dfs("", word);
        return answer;
    }


    private static void dfs(String str, String word){
        cnt++;

        if(str.equals(word)){
            answer = cnt - 1;
            return;
        }


        if(str.length() == 5){
            return;
        }

        for(int i = 0; i < inputs.length; i++){
            dfs(str + inputs[i], word);
        }
    }
}

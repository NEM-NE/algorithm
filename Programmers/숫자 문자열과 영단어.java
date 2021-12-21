class Solution {
    // 10:10
    static String[] list = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < list.length; i++){
            while(s.contains(list[i])){
                s = s.replace(list[i], i + "");
            }
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
package 타겟넘버;

public class Solution {
    static int TARGET;
    public int solution(int[] numbers, int target) {
        TARGET = target;

        int result = dfs(numbers, 0, 0);

        return result;
    }

    private static int dfs(int[] numbers, int idx, int cur){
        if(idx == numbers.length){
            if(cur == TARGET) return 1;
            else return 0;
        }

        int result = 0;
        result += dfs(numbers, idx+1, cur + numbers[idx]);
        result += dfs(numbers, idx+1, cur - numbers[idx]);

        return result;
    }
}

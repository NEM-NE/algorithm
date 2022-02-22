package 피로도;

class Solution2 {
    static int[][] dungeons;
    public int solution(int k, int[][] ary) {
        dungeons = ary;
        boolean[] visited = new boolean[dungeons.length];
        int cnt = dfs(k, visited, 0);

        return cnt;
    }

    public static int dfs(int k, boolean[] visited, int depth) {
        int result = depth;
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(k >= dungeons[i][0]) {
                result =
                        Math.max(result, dfs(k - dungeons[i][1], visited, depth+1));
            }
            visited[i] = false;
        }
        return result;
    }
}
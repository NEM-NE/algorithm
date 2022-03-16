package 가장먼노드;

import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    static int cnt;
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        //init
        cnt = 0;
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            map.add(new ArrayList<Integer>());
        }

        //input
        for(int[] v : edge){
            int a = v[0];
            int b = v[1];

            map.get(a).add(b);
            map.get(b).add(a);
        }

        //solve
        bfs(1);

        return cnt;
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            int curCnt = 0;
            for(int j = 0; j < size; j++){
                int num = queue.poll();

                for(int i = 0; i < map.get(num).size(); i++){
                    if(visited[map.get(num).get(i)]) continue;
                    //System.out.println(map.get(num).get(i));
                    visited[map.get(num).get(i)] = true;
                    queue.offer(map.get(num).get(i));
                    curCnt++;
                }
            }

            if(curCnt != 0) cnt = curCnt;
        }

    }
}

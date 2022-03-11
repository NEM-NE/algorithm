package 섬연결하기;

import java.util.*;

public class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int result = 0;
        for(int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int w = costs[i][2];

            if(find(parent, a) != find(parent, b)){
                union(parent, a, b);
                result += w;
            }
        }

        return result;
    }

    private int find(int[] parent, int k){
        if(parent[k] == k){
            return k;
        }else return parent[k] = find(parent, parent[k]);
    }

    private void union(int[] parent, int a, int b){
        int aa = find(parent, a);
        int bb = find(parent, b);

        if(aa > bb){
            parent[aa] = bb;
        }else {
            parent[bb] = aa;
        }
    }
}

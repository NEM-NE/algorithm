package B1922;

import java.io.*;
import java.util.*;

public class Main {
    // 13:07
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static PriorityQueue<Node> pq;
    static int[] parent;

    static class Node {
        int x, y, w;

        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Node(x, y, w));
        }

        //makeset
        for(int i = 1; i < parent.length; i++){
            parent[i] = i;
        }

        int sum = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(!(find(node.x) == find(node.y))){
                union(node.x, node.y);
                sum += node.w;
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }

    private static int find(int n){
        if(n == parent[n]){
            return n;
        }else return parent[n] = find(parent[n]);
    }

    private static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);

        if(aa < bb){
            parent[bb] = aa;
        }else {
            parent[aa] = bb;
        }
    }
}

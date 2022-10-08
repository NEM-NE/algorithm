package B18116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent = new int[1000001];
    static int[] count = new int[1000001];

    public static void main(String[] args) throws Exception{
        int tc = Integer.parseInt(br.readLine());

        //makeset
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            count[i] = 1;
        }

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            if("I".equals(oper)){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }else if("Q".equals(oper)){
                int a = Integer.parseInt(st.nextToken());

                sb.append(count[find(a)]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);

        if(aa < bb){
            parent[bb] = aa;
            count[aa] += count[bb];
        }else if(aa > bb){
            parent[aa] = bb;
            count[bb] += count[aa];
        }
    }

}

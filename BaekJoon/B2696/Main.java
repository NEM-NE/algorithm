package B2696;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            ArrayList<Integer> result = solve();

            sb.append(result.size());
            for (int j = 0; j < result.size(); j++) {
                if(j % 10 == 0) sb.append("\n");
                sb.append(result.get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static ArrayList<Integer> solve() throws Exception{
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int size = Integer.parseInt(br.readLine());

        for(int i = 1; i <= size; i++){
            if(i % 10 == 1) st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            list.add(num);

            if(i % 2 == 1){
                Collections.sort(list);
                result.add(list.get(i/2));
            }

        }

        return result;
    }
}

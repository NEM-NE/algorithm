package B2212;

import java.util.*;
import java.io.*;

public class Main {
    // 12:16
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> dist = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort((Integer a, Integer b) -> {return a - b;});

        for(int i = 0; i < n-1; i++){
            dist.add(list.get(i+1) - list.get(i));
        }

        dist.sort((Integer a, Integer b) -> {return b - a;});

        int sum = 0;
        for(int i = k-1; i < dist.size(); i++){
            sum += dist.get(i);
        }

        sb.append(sum);
        System.out.println(sb);
    }

}

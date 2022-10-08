package B1700;

import java.util.*;
import java.io.*;

public class Main {
    // 5:50
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> list = new LinkedList<Integer>();
        HashSet<Integer> multiTap = new HashSet<Integer>();
        for(int i = 0; i < k; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 멀티탭 채우기
        int idx = 0;
        for(; idx < k; idx++) {
            if(multiTap.size() == n) break;
            if(!multiTap.contains(list.get(idx))) multiTap.add(list.get(idx));
        }

        int cnt = 0;
        for(int i = idx; i < k - n; i += n){
            HashSet<Integer> newMultiTap = new HashSet<Integer>();
            int containCnt = 0;
            for(int j = i; j < i + n; j++){
                if(multiTap.contains(list.get(j))) containCnt++;
                newMultiTap.add(list.get(j));
            }
            multiTap = newMultiTap;
            cnt += n - containCnt;
        }

        //잔여 스케쥴 체크
        for(int i = k-(k%n)-1; i < k; i++){
            if(!multiTap.contains(list.get(i))) cnt++;
        }

        sb.append(cnt);
        System.out.println(sb);
    }

}

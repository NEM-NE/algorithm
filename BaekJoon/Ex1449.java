import java.util.*;
import java.io.*;

public class Ex1449 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        boolean[] ary = new boolean[2002];
        int[] pipe = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int idx = Integer.parseInt(st.nextToken());
            ary[idx] = true;
            pipe[i] = idx;
        }

        Arrays.sort(pipe);

        int cnt = 0;
        for(int i = 0; i < pipe.length; i++){
            int idx = pipe[i];

            if(!ary[idx]) continue;

            boolean isBlock = false;
            for(int j = idx; j < idx + l; j++){
                if(ary[j]) isBlock = true;
                ary[j] = false;
            }
            if(isBlock) cnt++;
        }

        sb.append(cnt);
        System.out.println(sb);
    }

}

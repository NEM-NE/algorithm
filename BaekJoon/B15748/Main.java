package B15748;

import java.util.*;
import java.io.*;

public class Main {
    // 2:00
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class RestStop {
        int position, tastinessUnit;

        public RestStop(int position, int tastinessUnit) {
            this.position = position;
            this.tastinessUnit = tastinessUnit;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int rf = Integer.parseInt(st.nextToken());
        int rb = Integer.parseInt(st.nextToken());
        RestStop[] stops = new RestStop[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int tastinessUnit = Integer.parseInt(st.nextToken());
            stops[i] = new RestStop(position, tastinessUnit);
        }

        Arrays.sort(stops, (s1, s2) -> s2.tastinessUnit - s1.tastinessUnit);

        long sum = 0;
        int bessiePos = 0;
        for(RestStop stop : stops){
            if(bessiePos >= stop.position) continue;
            long bessieSecond = (long) (stop.position - bessiePos) * rb;
            long johnSecond = (long) (stop.position - bessiePos) * rf;

            long restSecond = johnSecond - bessieSecond;
            sum += stop.tastinessUnit * restSecond;

            bessiePos = stop.position;
        }

        sb.append(sum);
        System.out.println(sb);
    }



}

package B13904;

import java.util.*;
import java.io.*;

public class Main {
    // 2:12
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int tc = Integer.parseInt(br.readLine());
        LinkedList<Assignment> list = new LinkedList<Assignment>();
        int[] result = new int[1001];
        // 2차원 배열에 다 넣어주기
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Assignment(d, w));
        }

        // 내림차순 정렬
        list.sort((Assignment a, Assignment b) -> { return b.score - a.score; });

        // 가장 늦게 제출 할 수 있도록 넣기
        for (Assignment assignment : list) {
            for(int i = assignment.deadLine; i > 0; i--){
                if(result[i] < assignment.score) {
                    result[i] = assignment.score;
                    break;
                }
            }
        }

        int sum = 0;
        for (int j : result) {
            sum += j;
        }

        sb.append(sum);
        System.out.println(sb);

    }

    static class Assignment {
        int deadLine, score;

        public Assignment(int deadLine, int score){
            this.deadLine = deadLine;
            this.score = score;
        }
    }


}

package 모의고사;

class Solution {

    static int[] sol1 = {1, 2, 3, 4, 5};
    static int[] sol2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] sol3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] cnt = new int[3];

        for(int i = 0; i < answers.length; i++){
            int sol1Num = sol1[i%sol1.length];
            int sol2Num = sol2[i%sol2.length];
            int sol3Num = sol3[i%sol3.length];

            if(sol1Num == answers[i]) cnt[0]++;
            if(sol2Num == answers[i]) cnt[1]++;
            if(sol3Num == answers[i]) cnt[2]++;
        }

        int max = 0;
        int size = 0;
        for(int i = 0; i < cnt.length; i++){
            if(max == cnt[i]){
                size++;
            }else if(max < cnt[i]){
                size = 1;
                max = cnt[i];
            }
        }

        int[] result = new int[size];
        int idx = 0;
        for(int i = 0; i < cnt.length; i++){
            if(max == cnt[i]){
                result[idx] = i + 1;
                idx++;
            }
        }

        return result;
    }
}

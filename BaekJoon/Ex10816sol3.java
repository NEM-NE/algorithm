import java.util.*;
import java.io.*;

public class Ex10816sol3 {
    // 5: 25
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> myCards = new ArrayList<Integer>();
    static int[] mAry;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            myCards.add(num);
        }

        int m = Integer.parseInt(br.readLine());
        mAry = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            mAry[i] = Integer.parseInt(st.nextToken());
        }

        //sorting
        Collections.sort(myCards);

        for(int i = 0; i < m; i++){
            int findNumber = mAry[i];
            int result = upperBound(findNumber) - lowerBound(findNumber);
            mAry[i] = result;
        }

        for(int i = 0; i < m; i++){
            sb.append(mAry[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int findNumber){
        int min = 0;
        int max = myCards.size() - 1;

        max++;
        while(min < max){
            int mid = (max + min) / 2;

            if(myCards.get(mid) >= findNumber){
                max = mid;
            }else {
                min = mid + 1;
            }
        }

        return (max + min) / 2;
    }

    public static int upperBound(int findNumber) {
        int min = 0;
        int max = myCards.size() - 1;

        max++;
        while(min < max){
            int mid = (max + min) / 2;

            if(myCards.get(mid) > findNumber){
                max = mid;
            }else {
                min = mid + 1;
            }
        }

        return (max + min) / 2;
    }

}

package B2343;

import java.io.*;
import java.util.*;

//12:51
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  public static void main(String[] args) throws Exception{
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<Integer> list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    int min = 1;
    for(int i = 0; i < n; i++){
      int num = Integer.parseInt(st.nextToken());
      list.add(num);
      min = Math.max(min, num);
    }

    int max = 1000000000;
    int result = 1000000000;
    while(max > min){
      int mid = (max + min) / 2;
//      System.out.println(max + " : " + min + " : " + mid);

      int cnt = getBlueraySize(list, mid);
//      System.out.println(cnt);
      if(cnt <= m){
        max = mid;
        result = Math.min(result, mid);
      }else if(cnt > m) {
        min = mid + 1;
      }
    }

    sb.append(result);
    System.out.println(sb);
  }

  public static int getBlueraySize(List<Integer> list, int mid){
    int cnt = 1;
    long subTotal = 0;
    for(int i = 0; i < list.size()-1; i++){
      subTotal += list.get(i);

      if(subTotal + list.get(i+1) > mid){
        cnt++;
        subTotal = 0;
      }
    }

    return cnt;
  }
}

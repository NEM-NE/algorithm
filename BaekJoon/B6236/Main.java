package B6236;

import java.util.*;
import java.io.*;

// 5: 28
public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  public static void main(String[] args) throws Exception{
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] days = new int[n];
    int maxExpense = 0;
    for(int i = 0; i < n; i++){
      days[i] = Integer.parseInt(br.readLine());
      maxExpense = Math.max(maxExpense, days[i]);
    }

    int max = 1000000000;
    int min = 1;
    int result = max;
    while(max > min){
      int mid = (max + min) / 2;
      if(maxExpense > mid){
        min = mid + 1;
        continue;
      }

      int count = 1;
      int price = mid;
      for(int i = 0; i < days.length; i++){
        if(price < days[i]){
          price = mid;
          count++;
        }

        price -= days[i];
      }



      if(count <= m) {
        max = mid;
        result = Math.min(result, mid);
      }else if(count > m){
        min = mid + 1;
      }
    }

    sb.append(result);
    System.out.println(sb);
  }

}

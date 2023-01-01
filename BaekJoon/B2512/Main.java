package B2512;


import java.io.*;
import java.util.*;

// 5:20
public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  public static void main(String[] args) throws Exception{
    int nSize = Integer.parseInt(br.readLine());

    List<Integer> regionList = new ArrayList<Integer>();
    st = new StringTokenizer(br.readLine());

    int temp = 0;
    int max = Integer.MIN_VALUE;
    int min = 1;
    for (int i = 0; i < nSize; i++) {
      int num = Integer.parseInt(st.nextToken());
      temp += num;
      max = Math.max(max, num);
      regionList.add(num);
    }

    int expense = Integer.parseInt(br.readLine());

    // 모든 요청이 배정될 수 있는 경우
    if(temp < expense){
      System.out.println(max);
      System.exit(0);
    }


    int result = expense;
    while(max >= min){
      int mid = (max + min) / 2;

      int sum = canAssignMoney(regionList, mid); // mid를 상한선으로 했을 때 총 필요한 예산을 계산
      if(sum < expense){
        min = mid + 1;
        result = mid;
      }else if(sum > expense){
        max = mid - 1;
      }else {
        result = mid;
        break;
      }
    }

    sb.append(result);
    System.out.println(sb);
  }

  public static int canAssignMoney(List<Integer> regionList, int expense){
    int result = 0;
    for (int i = 0; i < regionList.size(); i++) {
      result += regionList.get(i) < expense ? regionList.get(i) : expense;
    }

    return result;
  }
}


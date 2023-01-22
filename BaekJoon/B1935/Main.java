package B1935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

// 11 : 25
public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception{
    int n = Integer.parseInt(br.readLine());
    String postfixString = br.readLine();
    LinkedList<Double> list = new LinkedList<>();
    HashMap<Character, Double> map = new HashMap<>();

    for(int i = 0; i < n; i++){
      map.put((char) ('A' + i), Double.parseDouble(br.readLine()));
    }

    for(int i = 0; i < postfixString.length(); i++){
      char cur = postfixString.charAt(i);

      if(cur >= 'A' && cur <= 'Z'){
        double num = map.get(cur);
        list.add(num);
      }else {
        double a = list.pollLast();
        double b = list.pollLast();
        list.add(calculate(a, b, cur));
      }
    }

    sb.append(String.format("%.2f", list.pop()));
    System.out.println(sb);
  }

  public static double calculate(double a, double b, char operator){
    double result = 0;

    if(operator == '/'){
      result = b/a;
    }else if(operator == '*'){
      result = b*a;
    }else if(operator == '+'){
      result = b+a;
    }else if(operator == '-'){
      result = b-a;
    }

    return result;
  }
}

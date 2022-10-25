package B16637;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//12:13
public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static char[] operators;
  static int[] numbers;
  static int result = Integer.MIN_VALUE;

  public static void main(String[] args) throws Exception{
    int length = Integer.parseInt(br.readLine());
    String str = br.readLine();

    operators = new char[length/2];
    numbers = new int[length/2 + 1];

    parse(str, operators, numbers);

    if(length == 1){
      System.out.println(str.charAt(0));
      return;
    }

    solve(0, 0);

    sb.append(result);
    System.out.println(sb);
  }

  static void solve(int index, int sum) {
    if(index >= numbers.length){
      result = Math.max(result, sum);
      return;
    }

    solve(index+1, calculate(sum, numbers[index], (index != 0) ? operators[index-1] : '+'));

    if(index + 1 < numbers.length && index != 0) {
      solve(index+2, calculate(sum, calculate(numbers[index], numbers[index+1], operators[index]), operators[index-1]));
    }
  }


  static int calculate(int numberA, int numberB, char operatorA){
    if(operatorA == '*'){
      return numberA * numberB;
    }else if(operatorA == '+'){
      return numberA + numberB;
    }else{
      return numberA - numberB;
    }
  }

  static void parse(String str, char[] operators, int[] numbers){
    //parsing
    for(int i = 0; i < str.length(); i++){
      if(i%2 == 0){
        numbers[i/2] = str.charAt(i) - '0';
      }else {
        operators[i/2] = str.charAt(i);
      }
    }
  }
}

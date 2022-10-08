package 숫자짝꿍;

//10:45 11:05
class Solution {
  public String solution(String X, String Y) {
    int[] countList = new int[10];
    int[] temp = new int[10];

    for(int i = 0; i < X.length(); i++){
      int num = X.charAt(i) - '0';

      temp[num]++;
    }

    for(int i = 0; i < Y.length(); i++){
      int num = Y.charAt(i) - '0';

      if(temp[num] != 0){
        countList[num]++;
        temp[num]--;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = countList.length - 1; i >= 0; i--){
      for(int j = 0; j < countList[i]; j++){
        sb.append(i);
      }
    }

    String result = sb.toString();
    if(result.length() > 0 && result.charAt(0) == '0') result = Integer.parseInt(result) + "";
    return result.equals("") ? "-1" : result;

  }
}

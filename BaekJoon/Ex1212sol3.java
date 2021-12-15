import java.io.*;
import java.util.*;

public class Ex1212sol3 {	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            int num = str.charAt(i) - '0';
            sb.append(convertBinary(num));
        }

        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }

        System.out.println(sb);

    }

    public static String convertBinary(int num){
        StringBuilder sb = new StringBuilder();
        String str = "";
        while(num >= 2){
            int a = num % 2;
            str += a;
            num /= 2;
        }

        str += num;

        while(str.length() != 3){
            str += "0";
        }

        sb.append(str);
        sb.reverse();

        return sb.toString();
    }

}
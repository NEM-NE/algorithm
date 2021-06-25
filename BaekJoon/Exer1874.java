package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

/*
 *  스택을 이용한 문제
 *  
 *  문제 : 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
 *   임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
 *   
 *   키포인트 : 푸쉬를 하고나서 무조건 한번은 팝을 해야된다. / 팝 메서드는 무조건 스택의 최상위의 요소만 출력할 수 있다.
 *   
 *   
 */

public class Exer1874 {
	static Stack<Integer> base;
	static int[] ary;
	static int currentID;
	
	public static void main(String[] args) {
		try {
			//init
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int num = Integer.parseInt(br.readLine());
			ary = new int[num];
			base = new Stack<Integer>();
			currentID = 0;

			for(int i = 0; i < num; i++) {
				int N = Integer.parseInt(br.readLine());
				
				if(currentID < N) { //push
					for(int j = currentID+1; j <= N; j++) {
						base.push(j);
						sb.append("+\n");
					}
					currentID = N;
				}else if(base.peek() != N){
					System.out.println("NO");
					return;
				}
				
				base.pop();
				sb.append("-\n");
				
				
			}
			System.out.println(sb);


		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

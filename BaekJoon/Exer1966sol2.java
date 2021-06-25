package BaekJoon;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 역시 링크드리스트를 이용한 풀이 대신 제네릭을 정수가 아닌 정수 배열로 해서 품
 */

public class Exer1966sol2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, m, count; // m의 인덱스는 0부터
		
		for (int i = 0; i < t; i++) {
			LinkedList<int[]> queue = new LinkedList<>();
			count = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			
			for (int j = 0; j < n; j++)
				queue.add(new int[] { j, sc.nextInt() }); // 인덱스, 중요도 입력받기
			
			while (!queue.isEmpty()) { // 큐가 빌 때까지
				int[] now = queue.poll();
				boolean able = true;
				
				for (int[] q : queue)
					if (q[1] > now[1])
						able = false;
				
				if (able) {
					count++;
					if (now[0] == m)
						break;
				} else
					queue.add(now);
			}
			System.out.println(count);
		}

	}

}

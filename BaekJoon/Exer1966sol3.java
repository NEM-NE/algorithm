package BaekJoon;

import java.io.*;
import java.util.*;

/*
 * 큐를 이용해서 푼 경우 하지만 문제의 포인트인 우선순위를 구분하기 위해 따로 정수 배열을 만들어 정렬하고 풀이.
 */

public class Exer1966sol3 {
 
    static StringTokenizer st;
    static Queue<Integer> importance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
    
        int testCase = Integer.parseInt(st.nextToken());
        
        for(int t=0; t<testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int docCount = Integer.parseInt(st.nextToken());
            int wantToKnowNumOrder = Integer.parseInt(st.nextToken());
            importance = new LinkedList<Integer>(); // 중요도가 들어간 배열
            int[] sortedArray = new int[docCount]; // 중요도를 오름차순으로 정렬하기 위한 배열
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i< docCount; i++) {
                int importanceNum = Integer.parseInt(st.nextToken());
                importance.add(importanceNum);
                sortedArray[i] = importanceNum;
            }
            Arrays.sort(sortedArray); // 중요한 것부터 출력하기 위해 따로 배열을 만들어 오름차순 정렬
            
            int importanceOrder = sortedArray.length-1; // 중요도가 가장 큰 것부터 출력하기 위한 순서
            int order = 0; // 출력 횟수
            int calCount = 0; // 입력 순서에 맞춰서 순서를 기억하기 위한 변수
            
            while(true) {
                int pollNum = importance.poll();
                
                if(calCount == wantToKnowNumOrder) { // 큐에서 out 될 때 알고싶은 00번째 수를 알 수 있다. 
                    pollNum += 101; // 주어지는 수가 100이하이므로 다른 위치에 똑같은 중요도가 나오더라도 다른 점수로 만들어줌
                }
                calCount++;
                
                if(sortedArray[importanceOrder] == pollNum-101) { // 알고 싶은 수의 중요도만 101을 넘어가기 때문에 해당 숫자가 나오면 끝.
                    order++;
                    bw.write(String.valueOf(order));
                    bw.newLine();
                    break;
                    
                }else if(sortedArray[importanceOrder] == pollNum){ // 중요도가 높은 것이 출력되면 다음 중요도가 높은 것으로 이동
                    order++;
                    importanceOrder--;
                }else {
                    importance.add(pollNum); // 어느 해당 사항도 없으면 다시 큐 맨 뒤로 추가해준다
                }
            }
        }
        bw.flush();
    }    
}
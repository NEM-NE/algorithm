package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
 
/*
 *  단순히 큐 문제여서 큐만 쓰려고 애쓰다가 틀린 문제 입체적인 접근이 필요하지만 해당 풀이는 링크드 리스트를 이용해서 품
 *  링크드 리스트나 어레이 리스트 등의 자료구조를 구현해주는 클래스의 공부가 필요.
 *  
 *  get메서드를 통해 내가 구현하기 어려웠던 부분을 한번에 풀어줌.
 *  만약 내가 링크드 리스트를 통해 풀었다면 이렇게 풀었을 듯.
 *  
 */

public class Exer1966sol {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        
        for(int n=0 ; n<T ; n++){
            String[] input = reader.readLine().split(" ");
            String[] priority = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int count = 0;
            queue.clear(); // 큐 초기화
            
            for(int i=0 ; i<N ; i++)
                queue.add(Integer.parseInt(priority[i])); // 큐에 중요도 데이터 추가
            
            while(!queue.isEmpty()){
                boolean isPriority = true;
                
                for(int i=1 ; i<queue.size() ; i++){ // 맨 앞 데이터의 중요도가 가장 높은지 확인
                    if(queue.peek() < queue.get(i)){
                        isPriority = false;
                        break;
                    }
                }
                
                if(isPriority){ // 가장 높다면 큐에서 제거, 구하려는 값이 아니라면 M값 갱신
                    count++;
                    queue.poll();
                    
                    if(M == 0)
                        break;
                    else 
                        M -= 1;
                }
                else { // 중요도가 가장 높은 문서가 아니라면 뒤로 보내고 M값 갱신
                    int temp = queue.poll();
                    queue.add(temp);
                    M = (M==0) ? queue.size()-1 : --M;
                }
            }
            builder.append(count).append("\n");
        }
        System.out.println(builder);
    }
}
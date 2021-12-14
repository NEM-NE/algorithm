import java.io.*;
import java.util.*;

public class Ex10845sol2 {
	// 11 : 21
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        
        int tc = Integer.parseInt(br.readLine());
        int result = 0;
        MyQueue queue = new MyQueue(tc);
        for(int i = 0; i < tc; i++) {
            String oper = br.readLine();
            
            if(oper.contains("push")){
                result = Integer.parseInt(oper.substring(5, oper.length()));
                queue.push(result);
            }else if(oper.contains("front")){
                result = queue.front();
                sb.append(result).append("\n");
            }else if(oper.contains("back")){
                result = queue.back();
                sb.append(result).append("\n");
            }else if(oper.contains("size")){
                result = queue.size();
                sb.append(result).append("\n");
            }else if(oper.contains("empty")){
                result = queue.empty();
                sb.append(result).append("\n");
            }else if(oper.contains("pop")){
                result = queue.pop();
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class MyQueue {
        int capacity;
        int size;
        int[] ary;
        private int rear;
        private int front;

        public MyQueue(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.ary = new int[capacity];
            this.front = 0;
            this.rear = 0;
        }

        public boolean push(int val) {
            try {
                this.rear = ((this.rear+1) % this.capacity);
                this.ary[this.rear] = val;
                this.size++;
                return true;   
            } catch (Exception e) {
                return false;
            }
        }

        public int pop() {
            if(empty() == 1) return -1;
        
            this.front = ((this.front + 1) % this.capacity);
            int result = this.ary[this.front];
            this.ary[this.front] = 0;
            this.size--;
            return result;
        }

        public int size() {
            return this.size;
        }

        public int empty() {
            return (this.size == 0) ? 1 : 0;
        }

        public int front() {
            if(empty() == 1) return -1;

            int index = ((this.front + 1) % this.capacity);
            return this.ary[index];
        }

        public int back() {
            if(empty() == 1) return -1;

            return this.ary[this.rear];
        }
    }
	
}
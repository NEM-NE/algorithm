import java.util.*;
import java.io.*;

public class Ex17509 {
    // 09:09
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Node[] nodeAry = new Node[11];

        for(int i = 0; i < 11; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            nodeAry[i] = new Node(d, l);
        }

        Arrays.sort(nodeAry, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.d - o2.d;
            }
            
        });

        int minute = nodeAry[0].d;
        int sum = minute + nodeAry[0].l * 20;
        for(int i = 1; i < 11; i++){
            minute += nodeAry[i].d;
            sum += minute + 20 * nodeAry[i].l;
        }

        sb.append(sum);
        System.out.println(sb);
    }

    static class Node {
        int d, l;

        public Node(int d, int l){
            this.d = d;
            this.l = l;
        }
    }

}

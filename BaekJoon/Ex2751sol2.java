import java.io.*;
import java.util.*;

public class Ex2751sol2 {
	
	public static void main(String[] args) throws IOException {		
		Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();

        int tc = scanner.nextInt();

        for(int i = 0; i < tc; i++){
            list.add(scanner.nextInt());
        }

        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });

        for(int i = 0; i < tc; i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
		
	}
	
}
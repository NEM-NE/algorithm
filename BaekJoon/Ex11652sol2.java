import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Ex11652sol2 {
	// 6 : 03
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int tc = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> list = new ArrayList<BigInteger>();

        for(int i = 0; i < tc; i++){
            list.add(new BigInteger(br.readLine()));
        }

        Collections.sort(list);

        Map<BigInteger, Integer> map = new LinkedHashMap<BigInteger, Integer>();
        for(int i = 0; i <tc; i++){
            if(map.get(list.get(i)) == null){
                map.put(list.get(i), 1);
            }else {
                int cnt = map.get(list.get(i));
                map.put(list.get(i), cnt+1);
            }
        }

        Set set = map.entrySet();

        Iterator it = set.iterator();

        int max = 0;
        BigInteger result = new BigInteger("0");
        while(it.hasNext()){
            Map.Entry<BigInteger, Integer> entry = (Map.Entry<BigInteger, Integer>) it.next();
            if(max < entry.getValue()){
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        sb.append(result);
        System.out.println(sb);

	}
	
}
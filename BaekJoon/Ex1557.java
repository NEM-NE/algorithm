import java.io.*;
import java.util.*;

public class Main {
	
	static long swap;
	
	static void merge(long[] ary, int start, int mid, int end) {
		long[] temp = new long[ary.length];
		int aIndex = start;
		int bIndex = mid + 1;
		int index = start;
		
		while(aIndex <= mid && bIndex <= end) {
			if(ary[aIndex] > ary[bIndex]) {
				temp[index++] = ary[bIndex++];
				swap += (mid + 1 - aIndex);
			}else {
				temp[index++] = ary[aIndex++];
			}
		}
		
		while(aIndex <= mid) {
			temp[index++] = ary[aIndex++];
		}
		
		while(bIndex <= end) {
			temp[index++] = ary[bIndex++];
		}
		
		for(int i = start; i <= end; i++) {
			ary[i] = temp[i];
		}
	}
	
	static void mergeSort(long[] ary, int start, int end) {
		if(start >= end) return;
		
		int mid = (start + end) / 2;
		
		mergeSort(ary, start, mid);
		mergeSort(ary, mid+1, end);
		merge(ary, start, mid, end);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		long[] ary = new long[tc];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < tc; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(ary, 0, ary.length - 1);
		
		sb.append(swap);
		
		System.out.println(sb);

	}

}

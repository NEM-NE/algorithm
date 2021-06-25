import java.util.*;
import java.io.*;


public class Main {

	static long[] list;
	static long[] temp;
	static long swap;
	
	static void merge(int start, int mid, int end) {
		int left = start;
		int right = mid+1;
		int index = start;
		
		while(left <= mid && right <= end) {
			if(list[left] > list[right]) {
				swap += right - index;  // 이렇게 풀어도 됨 mid + 1 - i;
				temp[index++] = list[right++];
			}else temp[index++] = list[left++];
		}
		
		while(left <= mid) {
			temp[index++] = list[left++];
		}
		
		while(right <= end) {
			temp[index++] = list[right++];
		}
		
		for(int i = start; i <= end; i++) {
			list[i] = temp[i];
		}
	}
	
	static void mergeSort(int start, int end, int size) {
		if(start >= end) return;
		int mid = (start + end) / 2;
		mergeSort(start, mid, size);
		mergeSort(mid+1, end, size);
		merge(start, mid, end);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		swap = 0;
		list = new long[size];
		temp = new long[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, size-1, size);
		
		sb.append(swap);
		
		System.out.println(sb);
	}

}

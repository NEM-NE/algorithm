package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1991 {
	// 10 : 07
	
	static class Node{
		char c;
		Node left, right;
		
		public Node(char c) {
			this.c = c;
		}
	}
	
	static Node[] tree;
	static StringBuilder sb;
	
	static void preOrder(int index) {
		sb.append(tree[index].c);
		if(tree[index].left != null) preOrder(tree[index].left.c - 'A');
		if(tree[index].right != null) preOrder(tree[index].right.c - 'A');
	}
	
	static void inOrder(int index) {
		if(tree[index].left != null) inOrder(tree[index].left.c - 'A');
		sb.append(tree[index].c);
		if(tree[index].right != null) inOrder(tree[index].right.c - 'A');
	}

	static void postOrder(int index) {
		if(tree[index].left != null) postOrder(tree[index].left.c - 'A');
		if(tree[index].right != null) postOrder(tree[index].right.c - 'A');
		sb.append(tree[index].c);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = null;
	
		int tc = Integer.parseInt(br.readLine());
		
		tree = new Node[tc];
		
		for(int i = 0; i < tc; i++) {
			tree[i] = new Node((char) ('A' + i));
		}
		
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			char c = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left != '.') tree[c-'A'].left = tree[left-'A'];
			if(right != '.') tree[c-'A'].right = tree[right-'A'];
		}
		
		preOrder(0);
		sb.append('\n');
		inOrder(0);
		sb.append('\n');
		postOrder(0);
		
		System.out.println(sb);
		
	}

}
import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Deque<Integer> deq = new ArrayDeque<>();
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			String[] s= str.split("");
			int n = Integer.parseInt(br.readLine());
			String str2 = br.readLine();
			String[] s2= str2.split("");
			for (int j = 1; j < s2.length-1; j++) {
				if(s2[j].equals(","))continue;
				else deq.add(Integer.parseInt(s2[j]));
			}
			//
			for (int j = 0; j < str.length(); j++) {
				if(s[j].equals("R")) R(deq);
				else D();
			}
			if(flag) {
				sb.append("[");
				while(!deq.isEmpty()){
					sb.append(deq.pollFirst());
					if(deq.isEmpty()) {
						sb.append("]");
						break;
					}
					sb.append(",");
				}
				bw.write(sb+"\n");
			}
			else bw.write("error\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//R 배열 순서 뒤집기
	public static Deque<Integer> R(Deque<Integer> d) {
		d.clear();
		for (Integer i : deq) {
			d.add(deq.pollLast());
		}
		flag = true;
		return d;
	}
	
	//D pollFirst 비어있으면 에러
	public static void D() {
		if(deq.isEmpty()) flag = false;
		else {
			deq.pollFirst();
			flag = true;
		}
	}
}
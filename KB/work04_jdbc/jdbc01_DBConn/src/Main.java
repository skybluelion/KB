import java.io.*;
import java.util.*;

public class Main {
	
	static int [][] dp = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			bw.write(comb(M,N)+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int comb(int n, int r) {
		if(dp[n][r] > 0) return dp[n][r];			
	
		if(n == r || r == 0) return dp[n][r] = 1;
	
		return dp[n][r] = comb(n-1,r-1) + comb(n-1,r);
	}
	
	
}
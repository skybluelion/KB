package com.edu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kickboard_me {

		static int M;
		static int N;
		static int[][] map;
		static boolean[][] visited;

		public static int execute(File path) throws FileNotFoundException {
			//Scanner sc = new Scanner(System.in);
			Scanner sc = new Scanner(path);
			M = sc.nextInt();
			N = sc.nextInt();
			map = new int[M][N];
			memo = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			visited = new boolean[M][N];
			int result = dfs(0,0);
			//System.out.println(result);		
			return result;
		}

		static int[] dr = { -1, 1, 0, 0 };
		static int[] dc = { 0, 0, -1, 1 };
		static int[][] memo;

		static int cnt = 0;
		static int dfs(int r, int c) {
			cnt++;



			// 코드구현
			return memo[r][c];
		}
		
		public static void main(String[] args) throws FileNotFoundException {
			System.out.println(execute(new File("input.txt")));
		}

}

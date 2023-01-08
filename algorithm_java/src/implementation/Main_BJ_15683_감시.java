package implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_15683_감시 {
	static int N, M;
	static int[][] workSpace;
	static int[][] workSpaceState;
	static List<CCTV> cctv = new ArrayList<CCTV>();
	static int[][] d = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상 하 좌 우
	static int[] dSize = { 0, 4, 2, 4, 4, 1 };
	static int[] dNum = { 0, 1, 4, 2, 3, 4 };
	static int ans, temp;

	static class CCTV {
		int type;
		int x;
		int y;

		public CCTV(int type, int x, int y) {
			super();
			this.type = type;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CCTV [type=");
			builder.append(type);
			builder.append(", x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]\n");
			return builder.toString();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		workSpace = new int[N][M];
		workSpaceState = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp != 0 && temp != 6)
					cctv.add(new CCTV(temp, i, j));
				workSpace[i][j] = temp;

			}
		}

//		for (CCTV tv : cctv) {
//			System.out.println(tv);
//		}

		ans = Integer.MAX_VALUE;
		temp = 0;

		observation(0, 0);
		System.out.println(ans);
	}

	static void observation(int cnt, int idx) {
		if (cnt == cctv.size()) {
			//printWorkSpace();
			temp = blindSpotCnt();
			// printWorkSpace();
			if (temp < ans)
				ans = temp;
			return;
		}
		CCTV ct = cctv.get(idx);
		int c = 0;
		for (int i = 0; i < dSize[ct.type]; i++) {
			int [][] workSpaceState = new int [N][M];
			saveState(workSpaceState);
			if (ct.type == 2) {
				//System.out.println("내가그린 기린그림");
				for (int j = c; j < dNum[ct.type] + c; j+=2) {
					observe((j + 2) % 4, ct.x, ct.y);
				}
			} else {
				for (int j = c; j < dNum[ct.type] + c; j++) {
					//System.out.println(j%4 + "방향으로 채웁니다.");
					observe(j % 4, ct.x, ct.y);
				}
			}
			c++;
			//printWorkSpace();
			observation(cnt + 1, idx + 1);
			rollBack(workSpaceState);
			//printWorkSpace();		
		}
	}

	static int blindSpotCnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (workSpace[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}

	static void observe(int i, int x, int y) {
		
		int nx = x + d[i][1];
		int ny = y + d[i][0];

		if (nx < 0 || nx >= N || ny < 0 || ny >= M || workSpace[nx][ny] == 6)
			return;
		else {
			if(workSpace[nx][ny] == 0) workSpace[nx][ny] = 7;
			observe(i, nx, ny);
		}
	}

	static void rollBack(int [][] ws) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				workSpace[i][j] = ws[i][j];
	}
	
	static void saveState(int [][] ws) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				ws[i][j] = workSpace[i][j];
	}

	static void printWorkSpace() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(workSpace[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

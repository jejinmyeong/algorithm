package implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N, M, D;
	static boolean[][] map;
	static boolean[][] mapCopy;
	static int R = 3;
	static int[] res;
	static int ans, temp;
	static int turnCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		mapCopy = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
					mapCopy[i][j] = true;
				}
			}
		}

		res = new int[R];
		comb(0, 0);
		System.out.println(ans);

	}

	static void comb(int cnt, int idx) {
		if (cnt == R) {
			mapCopyRight();
			temp = 0;
			turnCnt = 0;
			//System.out.println(Arrays.toString(res));
			attack(res);
			if(temp>ans) ans = temp;
			return;
		}
		for (int i = idx; i < M; i++) {
			res[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static void nextTrun() {
		turnCnt++;
		for (int i = N-2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				map[i+1][j] = map[i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			map[0][i] = false;
		}
		//mapPrint();
	}

	static void attack(int[] res) {
		
		while (!allKill()) {
			int[] resX = new int[res.length];
			int[] resY = new int[res.length];
			for (int r = 0; r < res.length; r++) {
				int d = Integer.MAX_VALUE;
				int x = N, y = M;
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						int dis = Math.abs(res[r] - j) + Math.abs(N - i);
						if (dis <= D && dis <= d && map[i][j]) {
							if (dis == d && j < y) {
								x = i;
								y = j;
							} else if (dis < d) {
								x = i;
								y = j;
								d = dis;
							}
						}
					}
				}
				//System.out.println("X : " + x + " Y : " + y);
				resX[r] = x;
				resY[r] = y;
			}
			for (int r = 0; r < res.length; r++) {
				if(resX[r]==N && resY[r]==M) continue;
				if(map[resX[r]][resY[r]]) {
					temp++;
					map[resX[r]][resY[r]] = false;
				}
			}			
			nextTrun();
//			mapPrint();
//			System.out.println();
//			System.out.println(allKill());			
		}
	}

	static boolean allKill() {
		for (int i = turnCnt; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j])
					return false;
			}
		}
		return true;
	}
	
	static void mapCopyRight() {
		for(int i =0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = mapCopy[i][j];
			}
		}
	}
	
	static void mapPrint() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_17143_낚시왕 {
	static class Shark {
		int r,c,s,d,z; // 위치 : (r, c)    속력 : s    이동방향 : d     크기 : z

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
		
	}
	
	static int R, C, M, ans;
	static Shark [] sharks = new Shark[M];
	static int [][] D = {{},{-1, 0},{1, 0},{1, 0},{-1, 0}}; // 상 하 우 좌
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sharks = new Shark[M];
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sharks[i] = new Shark(r,c,s,d,z);
		}
		
		
		
		// 낚시꾼이 오른쪽으로 한칸씩 이동
		for (int i = 1 ; i <= C ; i++) {
			sCatch(i);
			sMove();
			sKill();
//			for (Shark s : sharks) {
//				System.out.println(s);
//			}
		}
		
		System.out.println(ans);
	}
	static void sCatch(int col) {
		Shark s = null;
		int cIdx = -1;
		for (int i = 0 ; i < M ; i++) {
			if (sharks[i] == null) continue;
			
			if (sharks[i].c == col) {
				if (s == null) {
					s = sharks[i];
					cIdx = i;
				}else if (s != null && s.r > sharks[i].r) {
					s = sharks[i];
					cIdx = i;
				}
			}
		}
		if (cIdx != -1) {
//			System.out.println("포획한 상어: "+sharks[cIdx]);
			ans += sharks[cIdx].z;
			sharks[cIdx] = null;
		}
	}
	
	static void sMove() {
		for (int i = 0 ; i < M ; i++) {
			Shark s = sharks[i];
			if (s == null) continue;
			for (int z = 0 ; z < s.s ; z++) {
				int nx = s.r;
				int ny = s.c;
				if (s.d == 1) {
					nx -= 1;
				} else if (s.d==2) {
					nx += 1;
				} else if (s.d == 3) {
					ny += 1;
				} else {
					ny -= 1;
				}
				
				if (nx < 1) {
					s.d = 2;
					nx += 2;
				} else if (nx > R) {
					s.d = 1;
					nx -= 2;
				} else if (ny < 1) {
					s.d = 3;
					ny += 2;
				} else if (ny > C) {
					s.d = 4;
					ny -= 2;
				}
				
				s.r = nx;
				s.c = ny;
			}
		}
	}
	
	static void sKill() {
		for (int i = 0 ; i < M ; i++) {
			Shark s1 = sharks[i];
			if (s1 == null) continue;
			for (int j = 0 ; j < M ; j++) {
				if (i == j) continue;
				
				Shark s2 = sharks[j];
				if (s2 == null) continue;
				
				
				if (s1.r == s2.r && s1.c == s2.c) {
					if (s1.z > s2.z) {
						sharks[j] = null;
					} else {
						sharks[i] = null;
						break;
					}
				}
				
			}
		}
	}
}

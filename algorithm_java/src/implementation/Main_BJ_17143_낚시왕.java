package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		// 최대 상어 수 10000 속력 1000 = 10_000_000
		
		/*
		 * 순서 1 : 낚시꾼 오른쪽으로 한칸 이동
		 * 순서 2 : 열에 놓인 상어 중 육지에 가까운애 포획
		 * 순서 3 : 상어 움직임
		 * 순서 4 : 같은 위치에 놓인 상어 큰놈이 작은놈 잡아먹음
		 *  
		 */
		
		// 낚시꾼이 오른쪽으로 한칸씩 이동
		for (int i = 1 ; i <= C ; i++) {
			sCatch(i);
			sMove();
//			for (Shark s : sharks) {
//				System.out.println(s);
//			}
		}
		
		System.out.println(ans);
	}
	
	// 같은 열에 놓인 상어중 육지에 가까운애 잡고 ans에 상어 크기만큼 더해줌
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
	
	// 상어 움직임 & 잡아먹음
	static void sMove() {
		// 잡아먹기를 하기 위해서 map 배열을 생성하고 상어가 움직이고 나서 상어의 위치에 해당하는 map에 위치에 상어의 인덱스 저장,
		// 이미 존재한다면 해당 인덱스의 상어와 크기비교를 해서 작은놈 없앰
		int [][] map = new int [R+1][C+1];
		
		// 상어의 인덱스가 0부터 시작해서 -1로 초기화
		for (int i = 0 ; i < R+1; i++) {
			Arrays.fill(map[i], -1);
		}
		
		// 상어 배열을 돌면서
		for (int i = 0 ; i < M ; i++) {
			Shark s = sharks[i];
			
			// 상어가 잡혔거나 잡아 먹혀서 없어진 경우 continue
			if (s == null) continue;
			
			// 움직인 횟수가 속력과 같을 때까지 반복 1칸씩 움직이니까 시간초과
			for (int z = 0 ; z < s.s ;) {
				int nx = s.r;
				int ny = s.c;
				
				// 방향에 따라서 다음 x위치와 y위치 업데이트
				if (s.d == 1) {
					nx -= s.s-z;
				} else if (s.d==2) {
					nx += s.s-z;
				} else if (s.d == 3) {
					ny += s.s-z;
				} else {
					ny -= s.s-z;
				}
				
				// map 범위를 벗어난 경우에 현재 상어의 위치와 맵의 크기를 계산해서 움직인 거리를 늘려주고
				// 방향을 반대로 바꿔줌 방향을 바꾸었을 때 현재위치는 맵의 양 끝에 고정 시킴
				if (nx < 1) {
					z += s.r-1;
					s.d = 2;
					nx = 1;
				} else if (nx > R) {
					z += R-s.r;
					s.d = 1;
					nx = R;
				} else if (ny < 1) {
					z += s.c-1;
					s.d = 3;
					ny = 1;
				} else if (ny > C) {
					z += C-s.c;
					s.d = 4;
					ny = C;
				} 
				// map에 범위를 벗어나지 않았을 때는 상어가 움직인 횟수를 업데이트
				else {
					z += Math.abs(nx-s.r) + Math.abs(ny-s.c);
				}
				
				s.r = nx;
				s.c = ny;
			}
			
			// 상어를 잡아먹는 과정 상어의 위치에 해당하는 map이 -1인 경우에는  그자리에 상어의 인덱스 삽입
			// 이미 다른 상어가 존재했을 때는 서로의 크기를 비교하고 작은놈 없앰
			if (map[s.r][s.c] == -1) {
				map[s.r][s.c] = i;
			} else {
				if (s.z > sharks[map[s.r][s.c]].z) {
					sharks[map[s.r][s.c]] = null;
					map[s.r][s.c] = i;
				} else {
					sharks[i] = null;
				}
			}
		}
	}
}

package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_1767_프로세서연결하기 {
	static class Process{
		int x, y;

		public Process(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int N, ans, cnt;
	static int [][] map;
	static ArrayList<Process> p;
	static int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}}; // 방향 상, 하, 좌 , 우
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			N =  Integer.parseInt(br.readLine());
			
			map = new int [N][N];
			p = new ArrayList<>();
			// map 채우기
			for (int i = 0 ; i < N ;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || j == 0) continue;
						p.add(new Process(i, j));
					}
				}
			}
			
			/*
			 * 풀이 방법 브루트 포스
			 * 각 프로세스 에서 방향을 선택하고 전선을 채움
			 * 각 프로세스를 arraylist p에 저장하고 
			 * 인덱스를 늘려가면서 각 방향으로 돎
			 * 프로세스 연결에 성공하면 
			 */
			
			ans = Integer.MAX_VALUE;
			cnt = 0;
			
			connect(0,0,0);
			
			sb.append("#"+tc +" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	static void connect(int idx, int sum, int pCnt) {
		// 인덱스가 프로세스 개수와 같아지면 멈추고 사용된 전선의 길이와 연결에 성공한 프로세스 저장
		if (idx == p.size()) {
			if (cnt < pCnt) {
				cnt = pCnt;
				ans = sum;
			}else if (cnt == pCnt) {
				if (ans > sum) {
					ans = sum;
				}
			}
			return;
		}
		
		int x = p.get(idx).x;
		int y = p.get(idx).y;
		
		for (int d = 0 ; d < 4 ; d++) {
			if(available(x, y, d)) {
				int res = fillCable(x, y, d, 2);
				connect(idx+1, sum+res, pCnt+1);
				fillCable(x, y, d, 0);
			}
		}
		connect(idx+1, sum, pCnt);
	}
	
	static boolean available(int x, int y, int d) {
		int nx = x;
		int ny = y;
		
		while(true) {
			nx += D[d][0];
			ny += D[d][1];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				return true;
			}
			
			if (map[nx][ny] == 1 || map[nx][ny] == 2) {
				return false;
			}
		}
	}
	
	static int fillCable(int x, int y, int d, int s) {
		int nx = x;
		int ny = y;
		int sum = 0;
		while (true) {
			nx += D[d][0];
			ny += D[d][1];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
			map[nx][ny] = s;
			sum++;
		}
		
		return sum;
	}
	
	static void printMap() {
		for(int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j< N ; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

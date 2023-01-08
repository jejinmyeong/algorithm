package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1247_최적경로 {
	static class structure{
		int x;
		int y;
		
		public structure(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("structure [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]\n");
			return builder.toString();
		}
		
	}
	
	static structure company;
	static structure home;
	static structure [] customers;
	static boolean [] selected;
	static int N;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			company = new structure(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new structure(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			customers = new structure[N];
			selected = new boolean[N];
			
			for(int i = 0 ; i < N ;i++) {
				customers[i] = new structure(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
//			System.out.println("회사 :"+company);
//			System.out.println("집 :"+home);
//			System.out.println("고객 :"+Arrays.toString(customers));
			ans = Integer.MAX_VALUE;
			int curX = company.x;
			int curY = company.y;
			perm(0, 0, curX, curY);
			
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}
	static void perm(int cnt, int sum, int x, int y) {
		
		if (sum > ans) return;
		
		if (cnt == N) {
			int dis = Math.abs(x - home.x)+Math.abs(y - home.y);
			if(sum + dis < ans) {
				ans = sum + dis;
				//System.out.println("ans :"+ans);
			}
			
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			perm(cnt+1, sum + Math.abs(x-customers[i].x)+Math.abs(y-customers[i].y), customers[i].x, customers[i].y);
			selected[i] = false;
		}
	}
	
}

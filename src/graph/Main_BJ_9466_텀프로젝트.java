package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9466_텀프로젝트 {
	
	static int n, ans, end;
	static int [] choice;
	static int [] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			
			ans = n = Integer.parseInt(br.readLine());
			
			choice = new int[n+1];
			visited = new int[n+1];
						
			st = new StringTokenizer(br.readLine());
			for (int i = 1 ; i <= n ; i++) {
				choice[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1 ; i <= n ; i++) {
                if (visited[i] != 0) continue;
				dfs(i, choice[i]);
			}
			
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean dfs(int s, int n) {
		if (visited[n] == s) {
			end = n;
			return true;
		}
		
		if (visited[n] != 0) return false;
		
		visited[n] = s;
		
		boolean res = dfs(s, choice[n]);
		if(res && n != end) {
			ans--;
			return true;
		} else if (res && n == end){
			ans--;
			return false;
		} else {
			return false;
		}
		
	}
	
}

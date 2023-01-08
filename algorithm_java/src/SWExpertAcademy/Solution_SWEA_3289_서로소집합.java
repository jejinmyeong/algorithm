package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합 {
	static int [] parents;
	
	static void make() {
		parents = new int[V+1];
		
		for(int i = 1 ; i < V+1 ; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
	}
	
	static int V, E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
						
			make();
			sb.append("#"+tc+" ");
			for (int i =0 ; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int com, a, b;
				com = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if(com == 1) {
					if(find(a)==find(b)) sb.append("1");
					else sb.append("0");
				} else {
					union(a, b);
				}
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);
	}
}

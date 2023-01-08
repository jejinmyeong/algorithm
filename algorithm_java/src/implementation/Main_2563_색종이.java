package implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		boolean[][] write = new boolean[100][100];
		
		int ans = 0;
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
						
			for (int i = x; i < x + 10 && i < 100; i++) {
				for (int j = y; j < y + 10 && j < 100; j++) {
					write[i][j] = true;
				}
			}		
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(write[i][j] == true) ans++;
			}
		}

		System.out.println(ans);
	}
}

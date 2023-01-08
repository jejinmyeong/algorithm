package jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고 {
	
	static class Chemical implements Comparable<Chemical> {
		int low;
		int high;
		
		public Chemical(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Chemical o) {
					
			return this.high - o.high;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Chemical [low=");
			builder.append(low);
			builder.append(", high=");
			builder.append(high);
			builder.append("]\n");
			return builder.toString();
		}
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		Chemical [] chemicals = new Chemical[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			chemicals[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		Arrays.sort(chemicals);
		
		int ans = 1;
		int high = chemicals[0].high;
		for (int i = 1; i < N ; i++) {
			if(chemicals[i].low > high) {
				ans++;
				high = chemicals[i].high;
			}
		}
		
		System.out.println(ans);
	}
}

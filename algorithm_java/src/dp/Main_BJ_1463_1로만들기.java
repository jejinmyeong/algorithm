package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> dp = new ArrayList<>();
		dp.add(0);
		dp.add(0);
		dp.add(1);
		dp.add(1);
		
		for (int i = 4 ; i <= N ; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				if (dp.get(i/3) <= dp.get(i/2)) {
					if (dp.get(i/3) <= dp.get(i-1))
						dp.add(dp.get(i/3)+1);
					else dp.add(dp.get(i-1)+1);
				} else {
					if (dp.get(i/2) <= dp.get(i-1))
						dp.add(dp.get(i/2)+1);
					else dp.add(dp.get(i-1)+1);
				}
				
			} else if (i % 3 == 0) {
				if (dp.get(i/3) <= dp.get(i-1))
					dp.add(dp.get(i/3)+1);
				else dp.add(dp.get(i-1)+1);
				
			} else if (i % 2 == 0) {
				if (dp.get(i/2) <= dp.get(i-1))
					dp.add(dp.get(i/2)+1);
				else dp.add(dp.get(i-1)+1);
			} else {
				dp.add(dp.get(i-1)+1);
			}
			
		}
		
		System.out.println(dp.get(N));
	}
}

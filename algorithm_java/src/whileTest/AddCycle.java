package whileTest;

import java.io.*;

public class AddCycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String num = br.readLine();
		if(Integer.parseInt(num)<10) {
			num = "0"+num;
		}
		
		String result = num;
		
		int answer = 0;
				
		do {
			int a,b;
			
			a = result.charAt(0) - '0';
			b = result.charAt(1) - '0';
			
			int next = a+b;
			
			result = Integer.toString(Integer.parseInt(result)%10)+Integer.toString(next%10);
			
			answer++;
						
		} while(!result.equals(num));
		
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}
}

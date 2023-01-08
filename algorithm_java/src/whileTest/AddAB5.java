package whileTest;

import java.io.*;

public class AddAB5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String nums = br.readLine();
			String[] num = nums.split(" ");
			
			int a,b;
			a = Integer.parseInt(num[0]);
			b = Integer.parseInt(num[1]);
			
			if(a==0 && b==0) break;
			
			bw.write((a+b)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}

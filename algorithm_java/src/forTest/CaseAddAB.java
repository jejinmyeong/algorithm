package forTest;

import java.io.*;

public class CaseAddAB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String num = br.readLine();
			String[] arr = num.split(" ");
			
			int a,b;
			a = Integer.parseInt(arr[0]);
			b = Integer.parseInt(arr[1]);
			
			bw.write("Case #"+(i+1)+": "+(a+b)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}

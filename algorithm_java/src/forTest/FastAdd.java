package forTest;

import java.io.*;

public class FastAdd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String bothNum = br.readLine();
			String []arr = bothNum.split(" ");
			
			int a,b;
			
			a = Integer.parseInt(arr[0]);
			b = Integer.parseInt(arr[1]);
			bw.write(a+b+"\n");
		}

		bw.flush();
		bw.close();

	}
}

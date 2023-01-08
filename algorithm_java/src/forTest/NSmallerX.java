package forTest;

import java.io.*;

public class NSmallerX {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		String[] arr = input.split(" ");
		
		int N,X;
		N = Integer.parseInt(arr[0]);
		X = Integer.parseInt(arr[1]);
		
		String nums = br.readLine();
		String[] numArr = nums.split(" ");
		
		for(int i=0;i<N;i++) {
			if (Integer.parseInt(numArr[i])<X) bw.write(numArr[i]+" ");
		}
		
		bw.flush();
		bw.close();
		
	}
}

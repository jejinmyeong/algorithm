package oneDimensionArray;

import java.io.*;

public class NumberOfNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] nums = new int[3];

		for (int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		int multiple = nums[0] * nums[1] * nums[2];

		int[] count = new int[10];

		while (multiple != 0) {
			count[multiple % 10]++;
			multiple /= 10;
		}

		for (int i : count) {
			bw.write(i + "\n");
		}

		bw.flush();
		bw.close();
	}

}

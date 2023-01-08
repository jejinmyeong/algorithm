package oneDimensionArray;

import java.io.*;

public class MinMax {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		n = Integer.parseInt(br.readLine());

		String[] nums = br.readLine().split(" ");

		int min = 1000000, max = -1000000;

		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(nums[i]) < min)
				min = Integer.parseInt(nums[i]);
			if (Integer.parseInt(nums[i]) > max)
				max = Integer.parseInt(nums[i]);
		}

		bw.write(min + " " + max);
		bw.flush();
		bw.close();

	}
}

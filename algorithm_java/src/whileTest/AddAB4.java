package whileTest;

import java.io.*;

public class AddAB4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = "";

		while ((input = br.readLine()) != null) {
			String[] nums = input.split(" ");
			int a, b;
			a = Integer.parseInt(nums[0]);
			b = Integer.parseInt(nums[1]);

			bw.write((a + b) + "\n");
		}

		bw.flush();
		bw.close();

	}
}

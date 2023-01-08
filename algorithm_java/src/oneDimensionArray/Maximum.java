package oneDimensionArray;

import java.io.*;

public class Maximum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] answer = { 0, 0 };

		for (int i = 0; i < 9; i++) {
			String num = br.readLine();
			if (Integer.parseInt(num) > answer[0]) {
				answer[0] = Integer.parseInt(num);
				answer[1] = i + 1;
			}
		}

		bw.write(answer[0] + "\n" + answer[1]);
		bw.flush();
		bw.close();

	}

}

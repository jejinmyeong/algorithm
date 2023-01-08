package oneDimensionArray;

import java.io.*;

public class OXQuiz {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			char[] result = input.toCharArray();

			int score = 0;
			int temp = 0;
			for (int j = 0; j < result.length; j++) {
				if (result[j] == 'O') {
					score += temp;
					temp++;
				} else {
					score += temp;
					temp = 0;
				}
			}
			if (temp != 0)
				score += temp;
			bw.write(score + "\n");
		}

		bw.flush();
		bw.close();
	}
}

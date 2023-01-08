package oneDimensionArray;

import java.io.*;

public class Remainder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] remainder = new int[42];

		for (int i = 0; i < 10; i++) {
			remainder[Integer.parseInt(br.readLine()) % 42]++;
		}

		int answer = 0;

		for (int i : remainder) {
			if (i != 0)
				answer++;
		}

		bw.write(answer + " ");
		bw.flush();
		bw.close();
	}
}

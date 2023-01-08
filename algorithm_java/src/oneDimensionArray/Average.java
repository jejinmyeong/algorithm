package oneDimensionArray;

import java.io.*;

public class Average {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] scores = br.readLine().split(" ");

		int max = 0;

		for (String score : scores) {
			if (Integer.parseInt(score) > max)
				max = Integer.parseInt(score);
		}

		double sum = 0;

		for (String score : scores) {
			sum += Double.parseDouble(score) / max * 100;
		}

		double average = sum / n;

		bw.write(Double.toString(average));
		bw.flush();
		bw.close();
	}
}

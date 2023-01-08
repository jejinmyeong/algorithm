package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> seq = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			seq.add(i);
		}

		int idx = 0;
		sb.append("<");
		while (true) {
			if (seq.size() == 1)
				break;
			idx = (idx + K-1) % seq.size();
			sb.append(seq.get(idx) + ", ");
			seq.remove(idx);
		}
		sb.append(seq.pop());
		sb.append(">");
		
		System.out.println(sb);
	}
}

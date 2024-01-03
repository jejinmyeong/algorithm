import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1 ; t <= T ; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int [] score = new int[N];

            for (int i = 0 ; i < N ; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score);

            sb.append("Class ").append(t).append("\n");
            sb.append("Max ").append(score[N - 1]).append(", ").append("Min ").append(score[0]).append(", ");

            int gap = 0;

            for (int i = 0 ; i < N - 1 ; i++) {
                gap = Math.max(gap, score[i + 1] - score[i]);
            }

            sb.append("Largest gap ").append(gap).append("\n");
        }

        System.out.print(sb);

    }
}

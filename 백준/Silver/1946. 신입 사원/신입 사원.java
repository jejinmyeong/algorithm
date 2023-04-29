import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Applicant implements Comparable<Applicant> {
        int a, b;
        Applicant(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Applicant o) {
            return this.a - o.a;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Applicant [] applicants = new Applicant[N];

            for (int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                applicants[i] = new Applicant(a, b);
            }

            Arrays.sort(applicants);

            int min = applicants[0].b;
            int ans = 1;

            for (int i = 1 ; i < N ; i++) {
                if (min < applicants[i].b) continue;
                min = applicants[i].b;
                ans++;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
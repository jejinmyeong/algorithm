import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Num implements Comparable<Num> {
        int n, idx;

        Num(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }

        @Override
        public int compareTo(Num o) {
            if (this.n == o.n) return this.idx - o.idx;
            return this.n - o.n;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Num [] A = new Num[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            A[i] = new Num(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(A);

        int [] P = new int[N];

        for (int i = 0 ; i < N ; i++) {
            P[A[i].idx] = i;
        }


        for (int p : P) {
            sb.append(p).append(" ");
        }

        System.out.println(sb);
    }
}
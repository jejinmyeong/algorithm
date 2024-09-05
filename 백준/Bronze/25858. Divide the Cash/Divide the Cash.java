import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int [] M = new int[N];
        int total = 0;

        for (int i = 0 ; i < N ; i++) {
            M[i] = Integer.parseInt(br.readLine());
            total += M[i];
        }

        total = D / total;
        for (int i = 0 ; i < N ; i++) {
            sb.append(total * M[i]).append("\n");
        }

        System.out.println(sb);

    }
}

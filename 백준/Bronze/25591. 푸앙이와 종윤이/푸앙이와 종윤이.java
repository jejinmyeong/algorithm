import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a = 100 - N;
        int b = 100 - M;
        int c = 100 - (a + b);
        int d = a * b;
        int q = d / 100;
        int r = d % 100;

        sb.append(a).append(' ').append(b).append(' ').append(c).append(' ').append(d).append(' ').append(q).append(' ').append(r).append("\n");
        sb.append(c + q).append(' ').append(r);

        System.out.println(sb);
    }
}
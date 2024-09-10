import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            double val1 = Double.parseDouble(st.nextToken()) * 10;
            double val2 = Double.parseDouble(st.nextToken()) * 10;

            sb.append(String.format("%.1f",((double) Math.round(Math.abs(val1 - val2))) / 10)).append("\n");
        }

        System.out.print(sb);
    }
}

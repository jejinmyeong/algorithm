import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] sizes = new int [6];

        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());

        int shirts = 0;

        for (int i = 0 ; i < 6; i++) {
            shirts += (int) Math.ceil((double) sizes[i] / T);
        }

        sb.append(shirts).append("\n");
        sb.append(N / P).append(" ").append(N % P);

        System.out.println(sb);
    }
}

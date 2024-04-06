import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            sb.append(S / (N + 1)).append("\n");
        }

        System.out.print(sb);
    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String input;
        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10_000_000;

            int n = Integer.parseInt(br.readLine());

            int [] legos = new int[n];

            for (int i = 0 ; i < n ; i++) {
                legos[i] = Integer.parseInt(br.readLine());
            }

            if (n == 0 || n == 1) {
                sb.append("danger").append("\n");
                continue;
            }

            Arrays.sort(legos);

            int start = 0;
            int end = n - 1;

            while (start < end) {
                int sum = legos[start] + legos[end];
                if (sum == x) break;
                else if (sum < x) start++;
                else end--;
            }

            if (start == end) {
                sb.append("danger").append("\n");
            } else {
                sb.append("yes").append(" ").append(legos[start]).append(" ").append(legos[end]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
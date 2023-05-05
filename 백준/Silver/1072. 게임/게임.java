import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = Y * 100 / X;

        long start = 0;
        long end = 1_000_000_000;

        while (start <= end) {
            long mid = (start + end) / 2;

            long _Z = (Y + mid) * 100 / (X + mid);

            if (Z < _Z) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start == 1_000_000_001 ? -1 : start);
    }
}

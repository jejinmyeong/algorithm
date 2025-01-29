import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0 ; i < Q ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 1) {
                sum += y;
            } else {
                sum -= y;
            }

            if (sum < 0) {
                System.out.println("Adios");
                return;
            }
        }

        System.out.println("See you next month");
    }
}

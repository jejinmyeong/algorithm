import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        int ans = 0;
        long sum = 0;

        for (int i = 1 ; i <= 65536 * 2 ; i++) {
            sum += i;
            if (sum > S) {
                ans = i;
                break;
            }
        }

        System.out.println(ans - 1);

    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 0;
        int idx = 1;
        while (start < N) {
            start += idx;
            idx++;
        }

        int p = start - N;

        if (idx % 2 != 0) System.out.println((idx - p - 1) + "/" + (p + 1));
        else System.out.println((p + 1) + "/" + (idx - p - 1));
    }
}
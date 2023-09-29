import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = -1;
        int x = -1, y = -1;

        for (int i = 1 ; i <= 9 ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= 9 ; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (max < now) {
                    max = now;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        String ans = recursiveSearch(N, B);

        System.out.println(ans);

    }

    public static String recursiveSearch(int N, int B) {
        String temp = "";

        if (N / B != 0) {
            temp = recursiveSearch(N / B, B);
        }

        if (N % B < 10) {
            temp += N % B;
        } else {
            temp += (char) ((N % B - 10) + 'A');
        }

        return temp;
    }
}


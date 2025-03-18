import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        if (A <= B || A - B > B) {
            System.out.println("NO");
            return;
        }

        sb.append("YES\n");
        sb.append((A - B)).append("\n");

        int cnt = A - B;

        for (int i = 1 ; i < cnt ; i++) {
            A -= 2;
            B -= 1;
            sb.append("aba\n");
        }

        for (int i = 0 ; i < B ; i++) {
            sb.append("ab");
        }

        sb.append("a\n");

        System.out.print(sb);
    }
}


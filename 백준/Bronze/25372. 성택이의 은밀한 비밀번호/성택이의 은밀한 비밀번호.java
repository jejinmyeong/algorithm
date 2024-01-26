import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String pw = br.readLine();

            if (pw.length() >=6 && pw.length() <= 9) {
                sb.append("yes");
            } else {
                sb.append("no");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
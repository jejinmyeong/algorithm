import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int year = Integer.parseInt(br.readLine());

            if ((year + 1) % (year % 100) == 0) {
                sb.append("Good");
            } else {
                sb.append("Bye");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
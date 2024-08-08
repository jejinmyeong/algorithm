import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int b = Integer.parseInt(br.readLine());

        int res = (5 * b) - 400;
        sb.append(res).append("\n");

        if (res == 100) {
            sb.append(0);
        } else if (res < 100) {
            sb.append(1);
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}

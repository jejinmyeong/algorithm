import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        int sum = N * (N + 1) / 2;

        sb.append(sum).append("\n");
        sb.append(sum * sum).append("\n");
        sb.append(sum * sum).append("\n");


        System.out.print(sb);
    }
}

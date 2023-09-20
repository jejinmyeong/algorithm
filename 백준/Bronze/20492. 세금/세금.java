import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine()) / 100;

        sb.append(N * 78).append(" ").append(N * 80 + (N * 20) / 100 * 78);

        System.out.println(sb);
    }
}

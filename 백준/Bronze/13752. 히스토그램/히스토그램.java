import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int k = Integer.parseInt(br.readLine());

            for (int j = 0 ; j < k ; j++) {
                sb.append("=");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
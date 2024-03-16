import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = N ; i > 0 ; i--) {
            for (int j = i ; j < N ; j++) {
                sb.append(" ");
            }
            for (int j = 1 ; j < i * 2 ; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 2 ; i <= N ; i++) {
            for (int j = i ; j < N ; j++) {
                sb.append(" ");
            }
            for (int j = 1 ; j < i * 2 ; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }


        System.out.print(sb);
    }
}
import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (i % 3 == 1 && j % 3 == 1 ||
                    i / 3 % 3 == 1 && j / 3 % 3 == 1 ||
                    i / 9 % 3 == 1 && j / 9 % 3 == 1 ||
                    i / 27 % 3 == 1 && j / 27 % 3 == 1 ||
                    i / 81 % 3 == 1 && j / 81 % 3 == 1 ||
                    i / 243 % 3 == 1 && j / 243 % 3 == 1 ||
                    i / 729 % 3 == 1 && j / 729 % 3 == 1 ||
                    i / 2187 % 3 == 1 && j / 2187 % 3 == 1 ||
                    i / 6561 % 3 == 1 && j / 6561 % 3 == 1) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
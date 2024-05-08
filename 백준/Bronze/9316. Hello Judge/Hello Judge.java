import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            sb.append("Hello World, Judge ").append(i + 1).append("!\n");
        }

        System.out.print(sb);
    }
}
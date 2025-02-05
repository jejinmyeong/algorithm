import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        int size = 1;

        while (size < K) size *= 2;

        sb.append(size).append(" ");

        int count = 0;

        while (K > 0) {
            if (K >= size) {
                K -= size;
            } else {
                size /= 2;
                count++;
            }
        }

        sb.append(count);

        System.out.println(sb);
    }
}

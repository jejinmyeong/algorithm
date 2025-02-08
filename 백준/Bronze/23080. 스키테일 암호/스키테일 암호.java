import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        String input = br.readLine();
        for (int i = 0 ; i < input.length() ; i += K) {
            sb.append(input.charAt(i));
        }

        System.out.println(sb);
    }
}

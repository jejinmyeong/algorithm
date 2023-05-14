import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0 ; i < input.length() ; i++) {
            char c = input.charAt(i);

            if (c <= 'z' && c >= 'a') sb.append((char)(c - 32));
            else sb.append((char)(c + 32));
        }

        System.out.println(sb);
    }
}
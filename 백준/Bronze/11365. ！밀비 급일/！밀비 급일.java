import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringBuilder str = new StringBuilder(br.readLine());

            if ("END".equals(str.toString())) {
                break;
            }

            sb.append(str.reverse()).append("\n");
        }

        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String str = br.readLine();

        for (int i = 1 ; i <= str.length() ; i++) {
            sb.append(str.charAt(i - 1));
            if (i % 10 == 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}

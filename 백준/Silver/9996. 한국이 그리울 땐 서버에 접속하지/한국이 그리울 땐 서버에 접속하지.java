import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        String base = br.readLine();
        int star = -1;
        for (int i = 0 ; i < base.length() ; i++) {
            if (base.charAt(i) == '*') {
                star = i;
                break;
            }
        }

        loop: for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();

            if (base.length() - 1 > str.length()) {
                sb.append("NE").append("\n");
                continue;
            }

            for (int j = 0 ; j < star ; j++) {
                if (base.charAt(j) != str.charAt(j)) {
                    sb.append("NE").append("\n");
                    continue loop;
                }
            }

            for (int j = base.length() - star - 1 ; j > 0 ; j--) {
                if (base.charAt(base.length() - j) != str.charAt(str.length() - j)) {
                    sb.append("NE").append("\n");
                    continue loop;
                }
            }

            sb.append("DA").append("\n");
        }

        System.out.print(sb);
    }
}



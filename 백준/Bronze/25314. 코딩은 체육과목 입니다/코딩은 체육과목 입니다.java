import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i += 4) {
            sb.append("long").append(" ");
        }

        sb.append("int");

        System.out.println(sb);
    }
}

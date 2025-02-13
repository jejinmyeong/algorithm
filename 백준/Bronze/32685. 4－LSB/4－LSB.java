import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = Integer.toBinaryString(Integer.parseInt(br.readLine()));
        String b = Integer.toBinaryString(Integer.parseInt(br.readLine()));
        String c = Integer.toBinaryString(Integer.parseInt(br.readLine()));

        String pw =
                String.format("%4s", a.length() > 4 ? a.substring(a.length() - 4) : a).replace(' ', '0') +
                String.format("%4s", b.length() > 4 ? b.substring(b.length() - 4) : b).replace(' ', '0') +
                String.format("%4s", c.length() > 4 ? c.substring(c.length() - 4) : c).replace(' ', '0');

        int ans = Integer.parseInt(pw, 2);
        System.out.println(String.format("%4s", String.valueOf(ans).length() < 4 ? String.valueOf(ans) : ans).replace(' ', '0'));
    }
}

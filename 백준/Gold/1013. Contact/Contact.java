import java.util.*;
import java.io.*;

public class Main {
    static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        String vega = "(100+1+|01)+";
        while (T-- > 0) {
            String s = br.readLine();

            if (s.matches(vega)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }
}
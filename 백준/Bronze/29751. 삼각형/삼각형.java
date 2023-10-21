import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());

        System.out.println(String.format("%.1f", W * H / 2));
    }

}
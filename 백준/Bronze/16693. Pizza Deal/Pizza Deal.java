import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double p = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());

        double r = Double.parseDouble(st.nextToken());
        double q = Double.parseDouble(st.nextToken());

        double x = a / p;
        double y = Math.PI * r * r / q;

        if (x < y) {
            System.out.println("Whole pizza");
        } else {
            System.out.println("Slice of pizza");
        }
    }
}

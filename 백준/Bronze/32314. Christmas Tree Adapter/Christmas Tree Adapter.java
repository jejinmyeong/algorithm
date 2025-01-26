import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        double w = Double.parseDouble(st.nextToken());
        double v = Double.parseDouble(st.nextToken());
        
        if (a <= (w / v)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

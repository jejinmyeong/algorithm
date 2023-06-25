import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum = 0;
        int cnt = 0;

        for (int i = 0 ; i < 20 ; i++) {
            st = new StringTokenizer(br.readLine());

            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();


            if ("P".equals(grade)) continue;

            cnt += score;

            if ("A+".equals(grade)) sum += score * 4.5;
            else if ("A0".equals(grade)) sum += score * 4.0;
            else if ("B+".equals(grade)) sum += score * 3.5;
            else if ("B0".equals(grade)) sum += score * 3.0;
            else if ("C+".equals(grade)) sum += score * 2.5;
            else if ("C0".equals(grade)) sum += score * 2.0;
            else if ("D+".equals(grade)) sum += score * 1.5;
            else if ("D0".equals(grade)) sum += score * 1.0;
        }

        System.out.println(sum / cnt);
    }
}
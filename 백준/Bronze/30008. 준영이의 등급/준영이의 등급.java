import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] grade = new int [K];
        int [] percent = new int [K];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            grade[i] = Integer.parseInt(st.nextToken());
            percent[i] = grade[i] * 100 / N;

            if (percent[i] <= 4){
                sb.append(1).append(" ");
            }else if(percent[i] <= 11){
                sb.append(2).append(" ");
            } else if (percent[i] <= 23) {
                sb.append(3).append(" ");
            }else if(percent[i] <= 40){
                sb.append(4).append(" ");
            }else if(percent[i] <= 60){
                sb.append(5).append(" ");
            }else if(percent[i] <= 77){
                sb.append(6).append(" ");
            }else if(percent[i] <= 89){
                sb.append(7).append(" ");
            }else if(percent[i] <= 96){
                sb.append(8).append(" ");
            }else {
                sb.append(9).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}

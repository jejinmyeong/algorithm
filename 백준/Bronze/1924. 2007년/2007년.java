import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int [] sum = new int[13];

        sum[0] = 0;

        for (int i = 1 ; i <= 12 ; i++) {
            sum[i] += sum[i - 1] + days[i - 1];
        }

        int day = sum[x - 1] + y;

        switch (day % 7) {
            case 0: {
                System.out.println("SUN");
                break;
            }
            case 1: {
                System.out.println("MON");
                break;
            }
            case 2: {
                System.out.println("TUE");
                break;
            }
            case 3: {
                System.out.println("WED");
                break;
            }
            case 4: {
                System.out.println("THU");
                break;
            }
            case 5: {
                System.out.println("FRI");
                break;
            }
            case 6: {
                System.out.println("SAT");
                break;
            }
        }

    }
}

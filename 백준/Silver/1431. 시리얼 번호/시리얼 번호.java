import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Serial implements Comparable<Serial> {
        String serial;
        int sum;

        Serial(String serial) {
            this.serial = serial;

            for (int i = 0 ; i < serial.length() ; i++) {
                if (serial.charAt(i) <= '9' && serial.charAt(i) >= '0') {
                    sum += serial.charAt(i) - '0';
                }
            }
        }

        @Override
        public int compareTo(Serial o) {
            if (this.serial.length() == o.serial.length()) {
                if (this.sum == o.sum) {
                    return this.serial.compareTo(o.serial);
                } else {
                    return this.sum - o.sum;
                }
            }

            return this.serial.length() - o.serial.length();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        Serial [] arr = new Serial[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = new Serial(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0 ; i < N ; i++) {
            sb.append(arr[i].serial).append("\n");
        }

        System.out.print(sb);

    }
}

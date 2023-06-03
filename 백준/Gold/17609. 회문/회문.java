import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String input = br.readLine();

            int left = 0;
            int right = input.length() - 1;

            sb.append(check(left, right, input, false)).append("\n");
        }

        System.out.print(sb);
    }

    static int check(int left, int right, String str, boolean flag) {
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                if (flag) return -1;
                
                int t1 = check(left + 1, right, str, true);
                int t2 = check(left, right - 1, str, true);

                if (t1 != 0 && t2 != 0) return 2;
                else return 1;
            }

            left++;
            right--;
        }
        return 0;
    }
}
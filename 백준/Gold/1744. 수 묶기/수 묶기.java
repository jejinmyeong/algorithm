import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) right.add(num);
            else left.add(num);
            sum += num;
        }

        if (N == 1) {
            System.out.println(sum);
            return;
        }

        Collections.sort(right, Collections.reverseOrder());
        Collections.sort(left);

        for (int i = 0 ; i < left.size() - 1 ; i++) {
            int temp = sum - left.get(i) - left.get(i + 1) + left.get(i) * left.get(i + 1);
            if (temp > sum) {
                sum = temp;
                i++;
            }
        }

        for (int i = 0 ; i < right.size() -1 ; i++) {
            int temp = sum - right.get(i) - right.get(i + 1) + right.get(i) * right.get(i + 1);
            if (temp > sum) {
                sum = temp;
                i++;
            }
        }

        System.out.println(sum);
    }
}
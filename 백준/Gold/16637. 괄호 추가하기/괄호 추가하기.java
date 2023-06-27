import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static int [] nums;
    static char [] operators;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char [] input = br.readLine().toCharArray();

        nums = new int[(N - 1) / 2];
        operators = new char[(N - 1) / 2];

        int start = input[0] - '0';

        for (int i = 1 ; i < N; i += 2) {
            operators[(i - 1) / 2] = input[i];
            nums[(i - 1) / 2] = input[i + 1] - '0';
        }

        System.out.println(dfs(0, start));
    }

    static int dfs(int idx, int temp) {
        if (idx == (N - 1) / 2) {
            return temp;
        }

        if (idx == (N - 1) / 2 - 1) {
            return calculate(idx, temp, nums[idx]);
        }

        return Math.max(dfs(idx + 1, calculate(idx, temp, nums[idx])), dfs(idx + 2, calculate(idx, temp, calculate(idx + 1, nums[idx], nums[idx + 1]))));
    }

    static int calculate (int idx, int left, int right) {
        return operators[idx] == '+' ? left + right : operators[idx] == '-' ? left - right : left * right;
    }
}
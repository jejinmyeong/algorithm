import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] nums = {"000", "001", "010", "011", "100", "101", "110", "111"};

        String input = br.readLine();

        sb.append(Integer.parseInt(nums[input.charAt(0) - '0']));

        for (int i = 1 ; i < input.length() ; i++) {
            int now = input.charAt(i) - '0';

            sb.append(nums[now]);
        }

        System.out.println(sb);
    }
}
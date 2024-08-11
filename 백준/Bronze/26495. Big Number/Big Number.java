import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[][] numbers = {
                {"0000", "   1", "2222", "3333", "4  4", "5555", "6666", "7777", "8888", "9999"},
                {"0  0", "   1", "   2", "   3", "4  4", "5",    "6",    "   7", "8  8", "9  9"},
                {"0  0", "   1", "2222", "3333", "4444", "5555", "6666", "   7", "8888", "9999"},
                {"0  0", "   1", "2",    "   3", "   4", "   5", "6  6", "   7", "8  8", "   9"},
                {"0000", "   1", "2222", "3333", "   4", "5555", "6666", "   7", "8888", "   9"}
        };
        
        String input = br.readLine();

        for (int i = 0 ; i < input.length() ; i++) {
            int n = input.charAt(i) - '0';

            for (int j = 0 ; j < 5 ; j++) {
                sb.append(numbers[j][n]);

                if (i + j != input.length() + 3) {
                    sb.append("\n");
                }
            }

            if (i != input.length() - 1) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}

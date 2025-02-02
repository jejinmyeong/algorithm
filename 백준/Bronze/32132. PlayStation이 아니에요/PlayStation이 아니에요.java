import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        while (true) {
            if (input.contains("PS4")) {
                input = input.replace("PS4", "PS");
            } else if (input.contains("PS5")) {
                input = input.replace("PS5", "PS");
            } else {
                break;
            }
        }

        System.out.println(input);
    }
}

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            double w = Double.parseDouble(br.readLine());

            if (w < 0) {
                break;
            }

            sb.append(String.format(("Objects weighing %.2f on Earth will weigh %.2f on the moon."), w, w * 0.167)).append("\n");
        }

        System.out.print(sb);
    }
}

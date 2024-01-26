import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String name = br.readLine();

        sb.append(":fan::fan::fan:\n:fan::").append(name).append("::fan:\n").append(":fan::fan::fan:");

        System.out.print(sb);

    }
}
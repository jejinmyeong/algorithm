import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        if (x % 3 == 1) {
            System.out.println("U");
        } else if (x % 3 == 2) {
            System.out.println("O");
        } else {
            System.out.println("S");
        }
    }
}

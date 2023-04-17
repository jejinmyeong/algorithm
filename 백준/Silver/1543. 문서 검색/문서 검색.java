import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int ans = 0;

        loop: for (int i = 0 ; i < s1.length() - s2.length() + 1 ; i++) {
            for (int j = 0 ; j < s2.length() ; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) continue loop;
            }
            ans++;
            i += s2.length() - 1;
        }

        System.out.println(ans);
    }
}
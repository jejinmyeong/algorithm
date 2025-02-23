import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if (input.length() == 26) {
            boolean[] suffix = new boolean[26];
            for (int i = 25; i >= 0; i--) {
                char ch = input.charAt(i);
                for (int j = ch - 'a'; j < 26; j++) {
                    if (suffix[j]) {
                        System.out.println(input.substring(0, i) + (char) (j + 'a'));
                        return;
                    }
                }
                suffix[ch - 'a'] = true;
            }
            
            System.out.println(-1);
            return;
        }

        boolean [] alphabet = new boolean[26];

        for (int i = 0; i < input.length(); i++) {
            alphabet[input.charAt(i) - 'a'] = true;
        }

        for (int i = 0 ; i < 26 ; i++) {
            if (!alphabet[i]) {
                System.out.println(input + (char) (i + 'a'));
                return;
            }
        }

        System.out.println(-1);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String [] num = {
                "####.##.##.####",
                "..#..#..#..#..#",
                "###..#####..###",
                "###..####..####",
                "#.##.####..#..#",
                "####..###..####",
                "####..####.####",
                "###..#..#..#..#",
                "####.#####.####",
                "####.####..####",
        };

        String h1 = "";
        String h2 = "";
        String m1 = "";
        String m2 = "";

        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());

            h1 += st.nextToken();
            h2 += st.nextToken();
            m1 += st.nextToken();
            m2 += st.nextToken();
        }

        int resH1 = 0;
        int resH2 = 0;
        int resM1 = 0;
        int resM2 = 0;

        for (int i = 0 ; i < 3 ; i++) {
            boolean flag = true;
            for (int j = 0 ; j < 15 ; j++) {
                if ((h1.charAt(j) == '#' && num[i].charAt(j) == '#') || (h1.charAt(j) == '.' && num[i].charAt(j) == '#') || (h1.charAt(j) == '.' && num[i].charAt(j) == '.')) {
                }
                else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                resH1 = i;
                break;
            }
        }

        for (int i = 0 ; i < 10 ; i++) {
            boolean flag = true;
            for (int j = 0 ; j < 15 ; j++) {
                if ((h2.charAt(j) == '#' && num[i].charAt(j) == '#') || (h2.charAt(j) == '.' && num[i].charAt(j) == '#') || (h2.charAt(j) == '.' && num[i].charAt(j) == '.')) {
                }
                else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                resH2 = i;
                break;
            }
        }

        for (int i = 0 ; i < 6 ; i++) {
            boolean flag = true;
            for (int j = 0 ; j < 15 ; j++) {
                if ((m1.charAt(j) == '#' && num[i].charAt(j) == '#') || (m1.charAt(j) == '.' && num[i].charAt(j) == '#') || (m1.charAt(j) == '.' && num[i].charAt(j) == '.')) {
                }
                else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                resM1 = i;
                break;
            }
        }

        for (int i = 0 ; i < 10 ; i++) {
            boolean flag = true;
            for (int j = 0 ; j < 15 ; j++) {
                if ((m2.charAt(j) == '#' && num[i].charAt(j) == '#') || (m2.charAt(j) == '.' && num[i].charAt(j) == '#') || (m2.charAt(j) == '.' && num[i].charAt(j) == '.')) {
                }
                else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                resM2 = i;
                break;
            }
        }

        System.out.println(resH1 + "" + resH2 + ":" + resM1 + "" + resM2);
    }
}

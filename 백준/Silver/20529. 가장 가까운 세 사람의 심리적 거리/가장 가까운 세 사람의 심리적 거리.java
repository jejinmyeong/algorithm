import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();

        String[] mbti = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};

        int [][] dist = new int[16][16];

        for (int i = 0 ; i < 16 ; i++) {
            map.put(mbti[i], i);

            for (int j = 0 ; j < 16 ; j++) {
                for (int k = 0 ; k < 4 ; k++) {
                    if (mbti[i].charAt(k) != mbti[j].charAt(k)) dist[i][j]++;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            if (N > 32) {
                sb.append(0).append("\n");
                continue;
            }
            String [] students = new String[N];

            for (int i = 0 ; i < N ; i++) {
                students[i] = st.nextToken();
            }


            int min = Integer.MAX_VALUE;

            for (int i = 0 ; i < N - 2 ; i++) {
                for (int j = i + 1 ; j < N - 1 ; j++) {
                    for (int k = j + 1 ; k < N ; k++) {
                        min = Math.min(min, dist[map.get(students[i])][map.get(students[j])] + dist[map.get(students[j])][map.get(students[k])] + dist[map.get(students[i])][map.get(students[k])]);
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.print(sb);
    }
}

package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_boj_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String [] arr = new String[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            String input = br.readLine();

            map.put(input, i);
            arr[i] = input;
        }

        for (int i = 0 ; i < M ; i++) {
            String input = br.readLine();

            if (input.charAt(0) > '0' && input.charAt(0) <= '9') {
                sb.append(arr[Integer.parseInt(input)]).append("\n");
            } else sb.append(map.get(input)).append("\n");
        }

        System.out.print(sb);
    }
}

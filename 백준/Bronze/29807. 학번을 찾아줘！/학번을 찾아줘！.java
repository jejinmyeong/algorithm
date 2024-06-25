import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int num = 0;
        if(n == 1) {
            num += score[0] * 508;
        }else if(n == 2) {
            num += score[0] * 508;
            num += score[1] * 212;
        }else if(n == 3) {
            if(score[0] > score[2]) {
                num += (score[0] - score[2]) * 508;
            }else {
                num += (score[2] - score[0]) * 108;
            }

            num += score[1] * 212;
        }else if(n == 4) {
            if(score[0] > score[2]) {
                num += (score[0] - score[2]) * 508;
            }else {
                num += (score[2] - score[0]) * 108;
            }

            if(score[1] > score[3]) {
                num += (score[1] - score[3]) * 212;
            }else {
                num += (score[3] - score[1]) * 305;
            }
        }else if(n == 5) {
            if(score[0] > score[2]) {
                num += (score[0] - score[2]) * 508;
            }else {
                num += (score[2] - score[0]) * 108;
            }

            if(score[1] > score[3]) {
                num += (score[1] - score[3]) * 212;
            }else {
                num += (score[3] - score[1]) * 305;
            }

            num += score[4] * 707;
        }

        num = num * 4763;
        System.out.println(num);
    }
}
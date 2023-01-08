package binararySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2110_공유기설치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, C;
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int [] point = new int [N];
		
		for (int i = 0 ; i < N ; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(point);
		
		int start = 1;
		int end = point[N-1] - point[0];
		
		int ans = 0;
		
		while (start <= end) {
			int mid = (start+end)/2;
			if (check(point, mid, C)) {
				ans = Math.max(ans, mid);
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean check(int [] arr, int dist, int c) {
		int cnt = 1;
		int last = arr[0]+dist;
		
		for (int i = 0 ; i < arr.length ; i++) {
			if (arr[i] >= last) {
				cnt++;
				last = arr[i]+dist;
			}
		}
		
		return cnt >= c;
	}
}

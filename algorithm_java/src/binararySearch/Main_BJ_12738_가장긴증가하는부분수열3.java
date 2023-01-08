package binararySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_12738_가장긴증가하는부분수열3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		final int MP = 1_000_000_001;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			int value = Integer.parseInt(st.nextToken())+MP;
			if (value > list.get(list.size()-1)) {
				list.add(value);
			} else {
				int left = 0; 
				int right = list.size() - 1;
				
				while (left < right) {
					int mid = (left+right)/2;
					if (list.get(mid) >= value) {
						right = mid;
					} else {
						left = mid+1;
					}
				}
				list.set(right, value);
			}
		}
		System.out.println(list.size()-1);
	}
}

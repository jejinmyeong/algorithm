package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_JO_1205_조커v2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> seq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int joker = 0;
		
		for (int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				joker++;
			} else {
				seq.add(num);
			}
			
		}
		
		Collections.sort(seq);
		
		int j = joker;	// 변하는 조커 변수
		int now = 0;	// 현재 카드 인덱스
		int next = now+1;	// 다음 카드 인덱스
		int pre = 0;	// 이전에 now와 next의 차이가 1보다 커서 조커를 사용한 위치를 저장할 변수
		int temp = 1;	// 현재 위치에서 스트레이트 수, 현재 카드 위치를 포함해야 하기 때문에 1로 시작
		int ans = 0;	// 전체에서 가장 큰 스트레이트 수 
		
		while(true) {
			if (now == seq.size()-1) {
				break;
			}
			// 모든 j를 소모할 때 까지 반복
			while (j != 0) {
				// 현재 카드 값과 다음 카드 값이 같으면
				if (seq.get(now).equals(seq.get(next))) {
					// 다음 카드로 이동
					now += 1;
					next = now+1;
				}
				// 현재 카드 값과 다음 카드 값의 차이가 남아있는 조커의 개수보다 작거나 같은 경우 현재 카드 값과 다음 카드 값 사이에 들어갈 수 있는 조커의 수 (seq.get(now) - seq.get(next))-1 개
				else if((seq.get(now) - seq.get(next))-1 <= j) {
					j -= (seq.get(now) - seq.get(next))-1;
					temp += (seq.get(now) - seq.get(next)); // now의 스트레이트 수 + 사용한 조커수 + next 카드 의 수
					if (((seq.get(now) - seq.get(next))-1) != 0) {// 만약에 사용한 조커의 수가 0개이면 인덱스 값만 증가 1개 이상이면 조커를 사용한 위치를 저장
						pre = next;
					}
					now += 1;
					next = now +1;
				} 
				
			}
		}
		
		
	}
}

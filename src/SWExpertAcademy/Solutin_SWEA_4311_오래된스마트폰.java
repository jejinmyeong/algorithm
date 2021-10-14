package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solutin_SWEA_4311_오래된스마트폰 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		loop: for (int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			// N= 터치가능한 숫자의 개수, O= 터치가능한 연산자 개수, M= 최대 터치가능한 횟수, W= 원하는 숫자
			int N, O, M, W;
			
			boolean [] result = new boolean [1000];
			
			N = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] nums = new int[N];
			
			for (int i = 0 ; i < N ; i++) {
				int num = Integer.parseInt(st.nextToken());
				nums[i] = num;
				result[num] = true;
			}
			
			st = new StringTokenizer(br.readLine());
			// 0=X 1='+' 2='-' 3='*' 4='/'
			boolean[] opers = new boolean[5];
			
			for (int i = 0 ; i < O ; i++) {
				opers[Integer.parseInt(st.nextToken())] = true;
			}
			
			W = Integer.parseInt(br.readLine());
			
			boolean flag = true;
			
			// 단순 입력으로만 만들 수 있는 경우
			// 원하는 숫자를 String타입으로 변환
			String sW = String.valueOf(W);
			// 각 자리 숫자가 입력 가능한지 확인
			for (int i = 0 ; i < sW.length() ; i++) {
				// 입력이 불가능하면 flag를 false로 변경
				if (!result[sW.charAt(0) - '0']) {
					flag = false;
					break;
				}
			}
			
			// 단순 입력으로 가능하면 sW의 길이 만큼 터치 해야하므로 길이 만큼 출력
			if(flag) {
				sb.append("#"+tc+" "+sW.length()+"\n");
				continue; // 다음 테이스 케이스로 이동
			}
			
			// 연산을 통해야 하는 경우
			// 총 터치 가능한 횟수만큼 반복
			
			boolean [] lastOper;
			// 처음 입력 가능한 숫자를 넣은 채로 시작하기 때문에 i=1로 시작 연산자 하나와 숫자 하나를 추가로 입력하기 때문에 터치횟수를 2개씩 늘림 마지막 연산은 항상 = 이 들어가야하므로 M-3까지 반복
			for (int i = 1 ; i < M-3 ; i+=2) {
				// 가장 마지막 연산 결과에서 계산
				lastOper = new boolean[1000];
				// j는 사용 가능한 숫자
				for (int j = 0 ; j < 1000 ; j++) {
					// 이전 연산결과의 값이 존재하는 경우
					if (result[j]) {
						for (int k = 1 ; k <= 4 ; k++) {
							// 연산자를 사용할 수 있는 경우
							if (opers[k]) {
								if (k==1) {
									for (int n=0 ; n < N ; n++) {
										int res = j+nums[n];
										// 결과가 999보다 크면 넘어감
										if (res > 999) continue;
										lastOper[res] = true;										
									}
								} else if(k==2) {
									for (int n=0 ; n < N ; n++) {
										int res = j-nums[n];
										// 결과가 0보다 작으면 넘어감
										if (res < 0) continue;
										lastOper[res] = true;										
									}
								} else if(k==3) {
									for (int n=0 ; n < N ; n++) {
										int res = j*nums[n];
										// 결과가 999보다 크면 넘어감
										if (res > 999) continue;
										lastOper[res] = true;										
									}
								} else if(k==4) {
									for (int n=0 ; n < N ; n++) {
										if(nums[n]==0) continue; // 0으로 나눌 수는 없음
										int res = j/nums[n];
										// 나눗셈으로 범위를 넘어가는 경우는 없음
										lastOper[res] = true;										
									}
								}
							}
						}
					}
				}
				System.out.print(tc+": "+i+": ");
				for (int j = 0 ; j < 1000 ; j++) {
					if(lastOper[j]) System.out.print(j+" ");
				}
				System.out.println();
				
				// 현재 결과가 원하는 숫자와 일치하는 경우 마지막에 = 연산자를 눌러야하므로 i+1
				if (lastOper[W]) {
					sb.append("#"+tc+" "+(i+3)+"\n");
					continue loop;
				}
				
				// 없으면 lastOper를 result로 옮김
				// 기존에 result를 초기화
				result = new boolean[1000];
				for (int j = 0 ; j < 1000 ; j++) {
					result[j] = lastOper[j];
				}
			}
			// 결국 아무데도 걸리지 않았으면 만들 수 없음
			sb.append("#"+tc+" "+"-1\n");
		}
		
		System.out.println(sb);
	}
}

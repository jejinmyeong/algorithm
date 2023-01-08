"""
k번째 수

세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.

배열 A와 B의 인덱스는 1부터 시작한다.

input:
첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.

output:
B[k]를 출력한다.
"""

import sys

input = sys.stdin.readline

n = int(input())

k = int(input())

def find(fst, end):
	if fst > end:
		print(fst)
		sys.exit()

	mid = (fst + end)//2
	cnt = 0

	for i in range(1, n+1):
		cnt += min(mid//i, n)
	if cnt >= k:
		find(fst, mid-1)
	else:
		find(mid+1, end)

find(1, k)
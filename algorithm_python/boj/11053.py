"""
가장 긴 증가하는 부분 수열

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

input:
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

output:
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
"""

import sys

n = int(sys.stdin.readline())

seq = list(map(int, sys.stdin.readline().split()))

dp = []
dp.append([1,seq[0]])
for i in range(1, n):
	check = 0
	for x, y in dp:
		if check == 0 and y < seq[i]:
			dp.append([x+1, seq[i]])
			check = 1
		if check == 1 and y < seq[i] and x >= dp[-1][0]:
			dp[-1][0] = x+1
	if check == 0:
		dp.append([1, seq[i]])

print(max(dp)[0])
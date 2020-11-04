"""
쉬운 계단 수

45656이란 수를 보자.

이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

input:
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

output:
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
"""

import sys

n = int(sys.stdin.readline())
dp = [0 for _ in range(10)]
answer = 0

for i in range(n):
	temp = [n for n in dp]
	if i == 0:
		for j in range(1,10):
			dp[j] += 1
	else:
		for j in range(10):
			if j == 0:
				dp[j] = temp[j+1]
			elif j == 9:
				dp[j] = temp[j-1]
			else:
				dp[j] = temp[j-1]+temp[j+1]
	

for i in dp:
	answer += i

print(answer%1000000000)
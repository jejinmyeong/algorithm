"""
LCS

LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

input:
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

output:
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

"""

import sys

input = sys.stdin.readline

_a = input()
_b = input()

dp = [0 for _ in range(len(_b)-1)]

for idx, i in enumerate(_a):
	s = 0
	dp_t = [n for n in dp]
	for jdx, j in enumerate(_b):
		if i == j:
			s = idx
			if jdx == len(_b)-1:
				break
			if jdx == 0:
				dp[jdx] = 1
			else:
				dp[jdx] = max(dp[jdx], max(dp_t[:jdx])+1)

print(max(dp))
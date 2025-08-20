import sys

input = sys.stdin.readline

n = int(input())
seq = list(map(int, input().split()))

dp = []
dp.append(seq[0])

for i in range(1, n):
	if dp[i-1]+seq[i] > seq[i]:
		dp.append(dp[i-1]+seq[i])
	else:
		dp.append(seq[i])

print(max(dp))
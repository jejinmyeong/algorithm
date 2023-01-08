"""
가장 긴 증가하는 부분 수열2

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

input:
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)

output:
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
"""

import sys

input = sys.stdin.readline

n = int(input())

a = list(map(int, input().split()))

dp = [0]

def seq(low, high, arr, i):
	global dp
	print(dp)

	if low > high:
		if low>=len(dp):
			dp.append(arr[i])
		else:
			dp[low] = a[i]
		return 0

	mid = (low+high)//2
	if dp[mid] < arr[i]:
		seq(mid+1, high, arr, i)
	else:
		seq(low, mid-1, arr, i)

for i in range(n):
	seq(0, len(dp)-1, a, i)

print(len(dp)-1)

import sys

input = sys.stdin.readline

n = int(input())
num = list(map(int, input().split()))

m = int(input())
mum = list(map(int, input().split()))

for i in mum:
	if i in num:
		print(1)
	else:
		print(0)
"""
수 찾기

N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

input:
첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
다음 줄에는 M(1≤M≤100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

output:
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

"""



import sys

input = sys.stdin.readline

n = int(input())
num = list(map(int, input().split()))

num.sort()

m = int(input())
mum = list(map(int, input().split()))

def search(num, val, fst, end):
	if fst > end:
		return False
	mid = (fst + end)//2

	if num[mid] > val:
		return search(num, val, fst, mid -1)
	elif num[mid] < val :
		return search(num, val, mid + 1, end)
	else:
		return True

for i in mum:
	if search(num, i, 0, n-1):
		print(1)
	else:
		print(0)

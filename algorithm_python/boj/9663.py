"""
N=Queen

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

input:
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

output:
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
"""

n = int(input())
answer = 0

def dfs(_list, add, n):
	_list.append(add)

	global answer
	if len(_list) == n:
		answer += 1
		return 0


	check = [n for n in range(n)]

	for idx, i in enumerate(_list):
		if i in check:
			check.remove(i)

		distance = len(_list) - idx

		if i - distance in check:
			check.remove(i - distance)
		if i + distance in check:
			check.remove(i + distance)

	if check:
		for idx, i in enumerate(check):
			dfs([n for n in _list], i, n)

for i in range(n):
	dfs([], i, n)
print(answer)
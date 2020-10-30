"""
스도쿠

스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.

나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.

또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.

이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.

게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

input:
아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.

output:
모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.

스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
"""
from sys import exit

def dfs(num):
	if num == zero:
		for n in sudoku:
			for i in n:
				print(i, end=' ')
			print()
		exit()

	check = [n+1 for n in range(9)]

	for n in sudoku[zero_idx[num][0]]:
		if n in check:
			check.remove(n)

	for n in scol[zero_idx[num][1]]:
		if n in check:
			check.remove(n)

	for n in sbox[zero_idx[num][0]//3 + 2*(zero_idx[num][0]//3) + zero_idx[num][1]//3]:
		if n in check:
			check.remove(n)
	if check:
		for n in check:
			sudoku[zero_idx[num][0]][zero_idx[num][1]] = n
			scol[zero_idx[num][1]][zero_idx[num][0]] = n
			sbox[(zero_idx[num][0]//3) + (zero_idx[num][0]//3)*2 + zero_idx[num][1]//3][(zero_idx[num][0]%3)*3 + zero_idx[num][1]%3] = n
			dfs(num + 1)
			
		sudoku[zero_idx[num][0]][zero_idx[num][1]] = 0
		scol[zero_idx[num][1]][zero_idx[num][0]] = 0
		sbox[(zero_idx[num][0]//3) + (zero_idx[num][0]//3)*2 + zero_idx[num][1]//3][(zero_idx[num][0]%3)*3 + zero_idx[num][1]%3] = 0
	else:
		return 1

sudoku = [list(map(int, input().split())) for _ in range(9)]
zero_idx = []
scol = [[] for _ in range(9)]

for idx, i in enumerate(sudoku):
	for jdx, j in enumerate(i):
		scol[jdx].append(j)
		if j == 0:
			zero_idx.append([idx, jdx])

sbox = [[] for _ in range(9)]

num = 0
for idx, i in enumerate(sudoku):
	if idx % 3 == 0 and idx != 0:
		num += 3
	for idx, j in enumerate(i):
		sbox[num + idx // 3].append(j)

zero = len(zero_idx)
dfs(0)
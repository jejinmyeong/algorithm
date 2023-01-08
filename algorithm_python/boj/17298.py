"""
오큰수

크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

input:
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

output:
총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
"""

import sys

input = sys.stdin.readline

class Stack(object):
	"""docstring for Stack"""
	def __init__(self):
		self.top = []

	def __len__(self):
		return len(self.top)

	def push(self, item):
		self.top.append(item)

	def pop(self):
		return self.top.pop()

	def peek(self):
		return self.top[-1]

def solution(seq):
	answer = [-1 for _ in range(len(seq))]
	stack = Stack()

	stack.push(0)
	i = 1

	while i<len(seq):
		while stack.top and seq[stack.top[-1]] < seq[i]:
			answer[stack.top[-1]] = seq[i]
			stack.pop()

		stack.push(i)
		i += 1

		print(stack.top)
	
	for a in answer:
		print(a, end=" ")


def main():
	n = int(input().rstrip('\n'))
	seq = list(map(int, input().split()))

	solution(seq)

if __name__ == '__main__':
	main()
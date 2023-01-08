"""
큐2 

정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

input:
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

output:
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
"""

import sys
from collections import deque

input = sys.stdin.readline

class Queue(object):
	"""docstring for Queue"""
	def __init__(self):
		self.top = deque()
	def __len__(self):
		return len(self.top)
	def push(self, item):
		self.top.appendleft(item)
	def pop(self):
		return self.top.pop() if self.top else -1
	def empty(self):
		return 0 if self.top else 1
	def front(self):
		return self.top[-1] if self.top else -1
	def back(self):
		return self.top[0] if self.top else -1
	def size(self):
		return len(self.top) if self.top else -1

def main():
	n = int(input().rstrip('/n'))
	queue = Queue()

	for _ in range(n):
		commend = input().split()

		if commend[0] == 'push':
			queue.push(commend[1])
		elif commend[0] == 'pop':
			print(queue.pop())
		elif commend[0] == 'size':
			print(len(queue))
		elif commend[0] == 'empty':
			print(queue.empty())
		elif commend[0] == 'front':
			print(queue.front())
		elif commend[0] == 'back':
			print(queue.back())
if __name__ == '__main__':
	main()

		
		
import sys

class Stack(object):
	"""docstring for Stack"""
	def __init__(self):
		self.top = []

	def __len__(self):
		return len(self.top)

	def push(self, item):
		self.top.append(item)

	def pop(self):
		self.top.pop(-1)
		
def solution(data):
	stack = Stack()
	for i in data:
		if i == '(':
			stack.push(i)
		else:
			if len(stack):
				stack.pop()
			else:
				return 'NO'

	return 'NO' if len(stack) else 'YES'


def main():
	n = int(input().rstrip('\n'))

	for _ in range(n):
		data = input().rstrip('\n')
		print(solution(data))

if __name__ == '__main__':
	main()
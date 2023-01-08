import sys

input = sys.stdin.readline

def stack_push(stack, num):
	stack.append(int(num))

def stack_pop(stack):
	print(stack.pop()) if stack else print(-1)

def stack_size(stack):
	print(len(stack))

def stack_empty(stack):
	print(0) if stack else print(1)

def stack_top(stack):
	print(stack[-1]) if stack else print(-1)

def main():
	n = int(input().rstrip('\n'))
	stack = []

	for _ in range(n):
		a = input().split()
		if a[0] == 'push':
			stack_push(stack, a[1])
		elif a[0] == 'pop':
			stack_pop(stack)
		elif a[0] == 'size':
			stack_size(stack)
		elif a[0] == 'empty':
			stack_empty(stack)
		elif a[0] == 'top':
			stack_top(stack)



if __name__ == '__main__':
	main()
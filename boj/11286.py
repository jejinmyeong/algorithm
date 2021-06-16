import sys
import heapq

input = sys.stdin.readline

def print_absolute(arr):
	return heapq.heappop(arr)[1] if len(arr) != 0 else 0

def insert_value(num, arr):
	if num < 0:
		heapq.heappush(arr, (-num, num))
	else:
		heapq.heappush(arr, (num,num))


def main():
	n = int(input().rstrip('\n'))
	a = []

	for _ in range(n):
		k = int(input().rstrip('\n'))
		if k == 0:
			print(print_absolute(a))
		else:
			insert_value(k, a)



if __name__ == '__main__':
	main()
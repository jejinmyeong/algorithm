import heapq
import sys

input = sys.stdin.readline

def solution(left, right, num):
	if len(left) == len(right):
		heapq.heappush(left, (-num, num))
	else:
		heapq.heappush(right, (num, num))

	if right and left[0][1] > right[0][1]:
		left_value = heapq.heappop(left)[1]
		right_value = heapq.heappop(right)[1]
		heapq.heappush(right, (left_value, left_value))
		heapq.heappush(left, (-right_value, right_value))

	return left[0][1]

def main():
	n = int(input().rstrip('\n'))
	left, right = [], []
	
	for _ in range(n):
		print(solution(left, right, int(input().rstrip('\n'))))

if __name__ == '__main__':
	main()
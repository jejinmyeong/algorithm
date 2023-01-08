def conv(n, b):
	T = '0123456789ABCDEF'
	i, j = divmod(n, b)

	if i == 0 :
		return T[j]
	else:
		return conv(i, b) + T[j]

def solution(n, t, m, p):
	answer =''
	arr = []
	num = 0

	temp = conv(num, n)
	while len(arr) != t*m + (p-1):
		if len(temp) == 0:
			num += 1
			temp = conv(num, n)
		else:
			arr.append(temp[0])
			temp = temp[1:]

	for idx, i in enumerate(arr):
		if (idx+1) % m == p%m:
			answer += i


	return answer

def main():
	n, t, m, p = map(int, input().split())
	print(solution(n, t, m, p))

if __name__ == '__main__':
	main()
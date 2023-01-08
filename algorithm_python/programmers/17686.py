def solution(files):
	answer = []
	seq_files = []

	for idx, f in enumerate(files):
		now = 0
		check = 0
		seq_files.append(['','','',idx])
		for jdx, w in enumerate(f):
			if w.isdigit() == 1:
				if check == 1:
					seq_files[idx][2] += w
				else:
					seq_files[idx][1] += w
			else:
				if len(seq_files[idx][1]) != 0:
					check = 1
				if check == 0:
					seq_files[idx][0] += w.lower()
				else:
					seq_files[idx][2] += w.lower()
					
		seq_files[idx][1] = int(seq_files[idx][1])



	seq_files.sort(key = lambda x: (x[0], x[1]))
	
	for i in seq_files:
		answer.append(files[i[3]])
	
	return answer


def main():
	files = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2"]
	print(solution(files))


if __name__ == '__main__':
	main()
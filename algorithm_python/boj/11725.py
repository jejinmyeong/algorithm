"""
트리의 부모찾기

루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

input:
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
"""

import sys

input = sys.stdin.readline

def dfs(curr, tree, parents):
	for node in tree[curr]:
		if parents[node] == 0:
			parents[node] = curr
			dfs(node, tree, parents)

def main():
	n = int(input().rstrip('\n'))

	tree = [[] for _ in range(n+1)]

	for _ in range(n-1):
		a,b = map(int, input().split())
		tree[a].append(b)
		tree[b].append(a)

	print(tree)

	parents = [0 for _ in range(n+1)]
	parents[1] = 1

	dfs(1, tree, parents)

	print(parents)


if __name__ == '__main__':
	main()


def solution(n, results):
    answer = 0
    win_table = [[0]*n for _ in range(n)]
    WIN, LOSE = 1, -1

    for w, l in results:
        win_table[w-1][l-1], win_table[l-1][w-1] = WIN, LOSE
    
    for now in range(n):
        wins = [idx for idx, rst in enumerate(win_table[now]) if rst == WIN]
        while wins:
            loser = wins.pop()
            for idx, temp in enumerate(win_table[loser]):
                if temp == WIN and win_table[now][idx] == 0:
                    win_table[now][idx], win_table[idx][now] = WIN, LOSE
                    wins.append(idx)
    
    answer = len(['ok' for rst in win_table if rst.count(0) == 1])


    return answer

def main():
    n = 5
    results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]

    print(solution(n, results))

if __name__ == "__main__":
    main()



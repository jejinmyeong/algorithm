def solution(n, results):
    answer = 0

    win_arr = [[0] *(n) for _ in range(n)]
    WIN, LOSE = 1, -1

    for w, l in results:
        win_arr[w-1][l-1], win_arr[l-1][w-1] = WIN, LOSE

    for i in range(n):
        loses = [idx for idx, rst in enumerate(win_arr[i]) if rst == LOSE]
        
        while loses:
            winer = loses.pop()
            for idx, rst in enumerate(win_arr[winer]):
                if rst == LOSE and win_arr[i][idx] == 0:
                    win_arr[i][idx], win_arr[idx][i] = LOSE, WIN
                    loses.append(idx)
            for w in win_arr:
                print(w)
            print()
    
    answer = len([x for x in win_arr if x.count(0) == 1])

    return answer

def main():
    n = 5
    results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]

    print(solution(n, results))

if __name__ == "__main__":
    main()
def solution(n, results):
    chart = [[0] * n for _ in range(n)] # 승패표
    WIN, LOSE = 1, -1
    for i, j in results: # 내입장 wind = 상대방 lose
        chart[i-1][j-1], chart[j-1][i-1] = WIN, LOSE
    
    for i in range(len(chart)): print(chart[i])
    print()

    for me in range(n):
        wins = [opp for opp, rst in enumerate(chart[me]) if rst == WIN]
        print(wins)
        while wins:
            loser = wins.pop()
            for opp, rst in enumerate(chart[loser]):
                if rst == WIN and chart[me][opp] == 0:
                    chart[me][opp], chart[opp][me] = WIN, LOSE
                    wins.append(opp)
        print(wins)
        print()
    
    for i in range(len(chart)): print(chart[i])
    print()


    return len(['know' for x in chart if x.count(0) == 1])

def main():
    n = 5
    results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]

    print(solution(n, results))

if __name__ == "__main__":
    main()
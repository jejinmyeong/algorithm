"""
n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.

선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
"""
from collections import defaultdict

def solution(n, results):
    answer = 0
    wins = defaultdict(set)
    loses = defaultdict(set)

    

    for a, b in results:
        wins[a].add(b)
        loses[b].add(a)
    
    print(wins)
    print(loses)
    
    for i in range(1, n+1):
        for loser in wins[i]:
            #print(loses[loser], loses[i],loses[loser]| loses[i])
            loses[loser] |= loses[i]
            #print(loses[loser])
        for winner in loses[i]:
            wins[winner] |= wins[i]
            #print('wins:', wins)
    print()
    print(wins)
    print(loses)

    for i in range(1, n+1):
        if len(wins[i]) + len(loses[i]) == n - 1:
            answer += 1

    return answer


def main():
    n = 5
    results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]

    print(solution(n, results))

if __name__ == "__main__":
    main()
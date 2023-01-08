"""
위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
"""

def solution(triangle):
    answer = 0
    dp = []
    
    for i in range(len(triangle)):
        if i == 0:
            dp.append([triangle[0][0]])
            continue
        temp = []
        for idx, val in enumerate(triangle[i]):
            if idx == 0:
                temp.append(dp[i-1][idx]+val)
            elif idx == len(triangle[i])-1:
                temp.append(dp[i-1][idx-1]+val)
            else:
                temp.append(max(dp[i-1][idx-1]+val, dp[i-1][idx]+val))
        dp.append(temp)

    answer = max(dp[-1])
    
    return answer

def main():
    triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
    print(solution(triangle))

if __name__ == "__main__":
    main()
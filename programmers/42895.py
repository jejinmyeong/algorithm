"""
N으로 표현
문제 설명
아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

제한사항
N은 1 이상 9 이하입니다.
number는 1 이상 32,000 이하입니다.
수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
최솟값이 8보다 크면 -1을 return 합니다.
"""
def solution(N, number):
    answer = 0
    ck = 0

    dp = [[],[],[]]
    dp[1] = [N]
    if number in dp[1]:
        return 1
    dp[2] = [int(str(N)+str(N)),N+N,N-N,N//N,N*N]
    if number in dp[2]:
        return 2

    for i in range(3,9):
        fst = ''
        for _i in range(i):
            fst += str(N)
        dp.append([int(fst)])
        for j in range(1, i//2+1):
            for n in dp[j]:
                for m in dp[i-j]:
                    dp[i].append(n+m)
                    dp[i].append(n-m)
                    dp[i].append(m-n)
                    dp[i].append(n*m)
                    if m != 0:
                        dp[i].append(n//m)
                    if n != 0:
                        dp[i].append(m//n)
        if number in dp[i]:
            ck = 1
            break;
    
    answer = len(dp)-1

    
    return answer if ck ==1 else -1

def main():
    N = 5
    number = 12

    print(solution(N, number))

if __name__ == '__main__':
    main()
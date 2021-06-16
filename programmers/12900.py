from math import factorial

import sys
sys.setrecursionlimit(10**6)

def f_factorial(dp, num):
    if dp[num] != 0:
        return dp[num]%1000000007
    else:
        dp[num] = num*f_factorial(dp,num-1)

    return dp[num]%1000000007

def r_factorial(dp, num):
    if dp[num] != 0:
        return dp[num]%1000000007
    else:
        dp[num] = r_factorial(dp,num+1)//(num+1)

    return dp[num]%1000000007

def solution(n):
    answer = 0
    dp = [0]*60001
    
    for two in range(n//2 +1):
        if two == 0:
            dp[n] = factorial(n)
        
        dp[0],dp[1] = 1,1
        
        t_val = two *2
        one = n - t_val
        
        amont = 0
        two_factorial = 0
        one_factorial = 0
        
        if n - (two+one) < (two+one):
            amont = r_factorial(dp, two+one)
        else:
            amont = f_factorial(dp, two+one)
        
        if n - two < two:
            two_factorial = r_factorial(dp, two)
        else:
            two_factorial = f_factorial(dp, two)
        
        if n - one < one:
            one_factorial = r_factorial(dp, one)
        else:
            one_factorial = f_factorial(dp, one)
            
            
        answer += amont//(one_factorial*two_factorial)
        
    return answer%1000000007

d = int(input())
print(solution(d))
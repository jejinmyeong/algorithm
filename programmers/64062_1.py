import copy
 
INF = 200000000
stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
k = 3
 
def solution(stones, k):
    left = 1; right = INF
 
    while left <= right:
        print(left, right)
        mid = (left + right) // 2
        tmp = copy.deepcopy(stones)
        print(tmp)
        for i in range(len(tmp)):
            tmp[i] -= mid
        print(tmp)
        cnt = 0
        check = False
        for i in range(len(tmp)):
            if tmp[i] <= 0:
                cnt += 1
            else:
                cnt = 0
 
            if cnt >= k:
                check = True
                break
 
        if check is True:
            right = mid - 1
        else:
            left = mid + 1
    return left

solution(stones, k)
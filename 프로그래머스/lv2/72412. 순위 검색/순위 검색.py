from itertools import combinations

def solution(info, query):
    answer = []
    dic = dict()

    for i in info:
        temp = list(i.split(" "))
        #print(temp)
        for t in range(len(temp)):
            com = list(combinations(temp[:-1], t))
            data = ''
            for c in com:
                data = ''.join(c)
                if dic.get(data):
                    dic[data].append(int(temp[-1]))
                else:
                    dic[data] = [int(temp[-1])]
    
    for key in dic.keys():
        dic[key].sort()
    

    for idx, q in enumerate(query):
        temp = list(q.split(" and "))
        ans = ''
        _t = temp[-1].split(" ")
        temp[-1] = _t[0]
        for t in temp:
            if t == '-':
                continue
            else:
                ans += t

        if ans in dic:
            scores = dic[ans]

            left = 0
            right = len(scores) -1

            while left <= right:
                mid = (left + right) //2

                if int(_t[1]) > scores[mid]:
                    left = mid +1
                else:
                    right = mid -1
            answer.append(len(scores) - left)
        else:
            answer.append(0)
    
    return answer
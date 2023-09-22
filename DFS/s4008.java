import math
 
T = int(input())
 
def calculate(p, a, b):
    if p == 0:
        return a + b
    elif p == 1:
        return a - b
    elif p == 2:
        return a * b
    else:
        return math.trunc(a/b)
 
 
def dfs(depth, ans):
    # 종료조건(숫자카드를 모두 쓰면)
    if depth >= N-1:
        global max_v, min_v
        if max_v < ans: max_v = ans
        if ans < min_v: min_v = ans
        return
    # 로직
    for i in range(4):
        if opers[i]:
            opers[i] -= 1
            dfs(depth + 1, calculate(i, ans, nums[depth + 1]))
            opers[i] += 1
 
for t in range(1, T + 1):
    N = int(input())
    opers = list(map(int, input().split()))
    nums = list(map(int, input().split()))
    max_v, min_v = -100000000, 100000000
    dfs(0, nums[0])
    print(f'#{t} {max_v - min_v}')

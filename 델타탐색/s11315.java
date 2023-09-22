T = int(input())
 
move = [(0, 1), (1, 0), (1, 1), (1, -1)]
 
def is_omok(N, arr):
    for i in range(N):
        for j in range(N):
            stx, sty = i, j
            if arr[stx][sty] == 'o':    
                for dx, dy in move:
                    nx = stx + dx
                    ny = sty + dy
                    cnt = 1
                    while cnt < 5:
                        if (0 <= nx < N and 0 <= ny < N) and arr[nx][ny] == 'o':
                            cnt += 1
                            nx += dx
                            ny += dy
                        else: break
                    if cnt >= 5: return True
    return False
                     
for t in range(1, T+1):
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    ans = 'YES' if is_omok(N, arr) else 'NO'
    print(f'#{t} {ans}')

T = int(input())
 
#둘이 붙었을 때 누가 이기는지?
def winner1(a, b):
    if(lst[a] == lst[b]):
        if a < b: return a
        else: return b
    elif(lst[a] == 1 and lst[b] == 2):
        return b
    elif(lst[a] == 2 and lst[b] == 3):
        return b
    elif(lst[a] == 3 and lst[b] == 1):
        return b
    else:
        return a
 
#토너먼트
def winner2(i, j):
    #마지막 한명 남을 때
    if i == j:
        return i
    #두명일때
    else:
        m = (i+j)//2
        l1 = winner2(i, m)
        l2 = winner2(m+1, j)
        return winner1(l1, l2)
     
 #테스트케이스 돌리기
for tc in range(1, T+1):
    N = int(input())
    lst = list(map(int, input().split()))
    win = winner2(0, len(lst)-1)
    print(f'#{tc} {win+1}')

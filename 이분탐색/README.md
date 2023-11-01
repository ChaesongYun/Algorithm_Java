# Lower Bound & Upper Bound
- 경계값을 찾는 알고리즘
- 데이터가 정렬되어 있어야 한다
- 이진탐색 기반-> 시간 복잡도: O(log n)

<br>
<br>

## Lower Bound
- 특정 값의 시작 위치를 찾는 알고리즘
![lower_bound](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcDcl4d%2FbtrUxdRXj9f%2FrEPGYLIYk7pK2bUXOKqWtK%2Fimg.png)

### 동작 방식
- left는 배열의 시작 위치로 right는 배열의 길이로 셋팅
1. 배열의 중간값을 가져온다
2. 중간값과 검색값을 비교한다
   - 중간값이 검색값보다 작다면 left값을 mid+1로
   - 중간값이 검색값보다 크거나 같다면 right값을 mid로
3. left >= right일 때까지 1번과 2번을 반복
4. 반복이 끝나면 right값이 lower bound가 된다

```Python
def lower_bound(arr, left, right, k):
  while left < right:
    mid = (left + right)//2
    if arr[mid] < k:
      left = mid + 1
    else:
      right = mid

  return right
```

<br>
<br>

## Upper Bound
- 특정 값보다 처음으로 큰 값의 위치를 찾는 알고리즘
![upper bound](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbL9VBl%2FbtrUus3uxhi%2FdAjAjIKvm1VpAt4CPgfRtK%2Fimg.png)

### 동작 방식
- left는 배열의 시작 위치, right는 배열의 길이
1. 배열의 중간값을 가져온다
2. 중간값과 검색값을 비교한다
   - 중간값이 검색값보다 작다면 left값을 mid+1로
   - 중간갑싱 검색값보다 크다면 right값을 mid로
3. left >= right일 때까지 1번과 2번을 반복
4. 반복이 끝나면 right값이 upper bound가 된다

```Python
def uppder_bound(arr, left, right, k):
  while left < right:
    mid = (left + right)//2
    if arr[mid] <= k:
      left = mid + 1
    else:
      right = mid

  return right
```

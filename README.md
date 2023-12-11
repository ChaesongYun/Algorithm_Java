# Algorithm_Java

## String
별거 아니긴 한데 String.charAt(i)보다
char arr[] = String.toCharArray() arr[i]가 더 빠르다..

## Kruskal 
- 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘<br>
(https://school.programmers.co.kr/learn/courses/30/lessons/62050)
- 최소 신장 트리를 만들기 위한 알고리즘
- 일단 모든 노드를 최대한 적은 비용으로 '연결'만 시키면 됨-> 모든 간선 정보를 오름차순으로 정렬한 뒤에 비용이 적은 간선부터 차근차근 그래프에 포함시킨다
- 사이클이 형성되지 않도록 조심

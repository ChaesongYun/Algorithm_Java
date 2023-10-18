import java.util.*;
//1번: 12345 반복
//2번: 21232425 반복
//3번: 3311224455 반복
class Solution {
    public int[] solution(int[] answers) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int arr3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int check[] = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == arr1[i%5]) check[0]++;
            if(answers[i] == arr2[i%8]) check[1]++;
            if(answers[i] == arr3[i%10]) check[2]++;
        }
        int max = Math.max(check[0], Math.max(check[1], check[2]));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(check[i] == max) ans.add(i+1);
        }
        Collections.sort(ans);
        int answer[] = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}

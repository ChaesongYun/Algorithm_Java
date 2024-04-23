package baekjoon2024;

import java.util.*;
import java.io.*;

public class B1174 {
    static ArrayList<Long> list;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        list = new ArrayList<>();
        for(int i = 0; i <= 9; i++){
            list.add(Long.valueOf(i));
            dfs(i);
        }
        Collections.sort(list);
        if(N-1 < list.size()) System.out.println(list.get(N-1));
        else System.out.println(-1);
    }
    public static void dfs(long n){
        String num = String.valueOf(n);
        int len = num.length();
        int last = Integer.parseInt(num.substring(len-1, len));
        for(int i = 0; i < last; i++){
            num += String.valueOf(i);
            list.add(Long.parseLong(num));
            dfs(Long.parseLong(num));
            num = num.substring(0, num.length()-1);
        }
    }
}

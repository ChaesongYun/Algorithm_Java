import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class swea_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc < 11; tc++) {
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			Stack<String> stack = new Stack<>(); //oper 임시 저장할 스택
			Queue<String> temp = new LinkedList<>(); //후위표기식 넣을 리스트
			//후위표기식
			for(int i = 0; i < N; i++) {
				String now = line.substring(i, i+1);
				if(now.equals("*")) {
					while(!stack.isEmpty() && stack.peek().equals("*")) {	
						temp.add(stack.pop());
					}
					stack.add(now);
				}
				else if(now.equals("+")) {
					while(!stack.isEmpty()) {
						temp.add(stack.pop());
					}
					stack.add(now);
				}
				else {
					temp.add(now);
				}
			}
			//나머지는 다 넣어주기 
			while(!stack.isEmpty()) {
				temp.add(stack.pop());
			}
			//계산하기
			for(int i = 0; i < N; i++) {
				String now = temp.poll();
				if (now.equals("+") || now.equals("*")) {
					int b = Integer.parseInt(stack.pop());
					int a = Integer.parseInt(stack.pop());
					if(now.equals("+")) stack.add(String.valueOf(a+b));
					else stack.add(String.valueOf(a*b));
				}
				else {
					stack.add(now);
				}
			}
			System.out.println("#" + tc + " " + stack.pop());
		}
	}
}

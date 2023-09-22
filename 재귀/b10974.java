import java.util.Scanner;

public class b10974 {
	static boolean visited[];
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		visited = new boolean[N];
		arr = new int[N];
		permutation(0, N);
	}
	static void permutation(int depth, int N) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			System.out.println(sb);
			sb.setLength(0);
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				permutation(depth+1, N);
				visited[i] = false;
			}
		}
	}
}

package recursion;

import java.util.Scanner;

/*
 * this program is responsible to generate combination for 0 to n-1 digit
 * this only takes the n as input
 */

public class Program1 {

	public static int N;
	public static int[] A = new int[100];
	public static boolean[] visited = new boolean[100];

	public static void print() {
		for (int i = 0; i < N; i++)
			System.out.print(A[i]);
		System.out.println();
	}

	public static void solve(int i) {
		if (i == N) {
			print();
			return;
		}

		for (int j = 0; j < N; j++) {
			if (visited[j] == false) {
				A[i] = j;
				visited[j] = true;
				solve(i + 1);
				visited[j] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// N = scanner.nextInt();
		N = 3;
		solve(0);
		scanner.close();
	}

}

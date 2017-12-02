package maxSumOfSubRectangle2DArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class TaskSolver {

		public static void solve(MyScanner in, MyWriter out) throws IOException {

			String str;
			while ((str = in.next()) != null) {
				int x = Integer.parseInt(str);
				int[][] arr = new int[x][x];
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < x; j++) {
						arr[i][j] = Integer.parseInt(in.next());
					}
				}
				out.println(getMaximumSumSubRectangleOf2DArray(arr));

			}

		}

		public static int getMaximumSumSubRectangleOf2DArray(int[][] arr) {
			int row = arr.length;
			int col = arr[0].length;
			int[] now = new int[row];
			int ans = 0;
			for (int i = 0; i < col; i++) {
				Arrays.fill(now, 0);
				for (int j = i; j < col; j++) {
					for (int k = 0; k < row; k++) {
						now[k] += arr[j][k];
					}
					ans = Math.max(ans, getMaximumSubArraySum(now));
				}
			}
			return ans;
		}

		public static int getMaximumSubArraySum(int[] arr) {
			int currentSum = arr[0], globalSum = arr[0];
			for (int i = 1; i < arr.length; i++) {
				currentSum = Math.max(arr[i], currentSum + arr[i]);
				globalSum = Math.max(globalSum, currentSum);
			}
			return globalSum;
		}

	}

	public static void main(String[] arg) {
		try {
			MyScanner in = new MyScanner();
			MyWriter out = new MyWriter();
			TaskSolver.solve(in, out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class MyWriter extends PrintWriter {
		MyWriter() throws FileNotFoundException {
			super(System.out);
		}

		void printArrayInOneLine(int[] a) {
			print('[');
			for (int i : a) {
				print(i + " ");
			}
			println(']');
		}

	}

	static class MyScanner {

		private BufferedReader br;
		private StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					return null;
				}
			}
			return st.nextToken();
		}

		public String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

}
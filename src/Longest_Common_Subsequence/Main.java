package Longest_Common_Subsequence;

public class Main {

	public static char[] X;
	public static char[] Y;

	public static int lcs(int m, int n) {

		if (m == 0 || n == 0)
			return 0;

		if (X[m - 1] == Y[n - 1]) {
			return 1 + lcs(m - 1, n - 1);
		} else {
			return Math.max(lcs(m, n - 1), lcs(m - 1, n));
		}

	}

	public static void main(String[] args) {

		String s1 = "abcb";
		String s2 = "bdab";

		X = s1.toCharArray();
		Y = s2.toCharArray();

		System.out.println("Length of LCS is" + " " + lcs(X.length, Y.length));

	}

}
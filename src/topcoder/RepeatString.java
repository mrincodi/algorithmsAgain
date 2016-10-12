package topcoder;

import java.util.Arrays;

public class RepeatString {
    static final int INF = (int) 1e9;
 
    public int minimalModify(String s) {
        int res = INF;
        for (int middle = 0; middle <= s.length(); ++middle) {
            String a = s.substring(0, middle);
            String b = s.substring(middle);
            res = Math.min(res, doit(a, b));
        }
        return res;
    }
 
    private int doit(String a, String b) {
        int[][] res = new int[a.length() + 1][b.length() + 1];
        for (int[] x : res) Arrays.fill(x, INF);
        res[0][0] = 0;
        for (int i = 0; i <= a.length(); ++i) {
            for (int j = 0; j <= b.length(); ++j) {
                if (i < a.length()) {
                    res[i + 1][j] = Math.min(res[i + 1][j], res[i][j] + 1);
                }
                if (j < b.length()) {
                    res[i][j + 1] = Math.min(res[i][j + 1], res[i][j] + 1);
                }
                if (i < a.length() && j < b.length()) {
                    res[i + 1][j + 1] = Math.min(res[i + 1][j + 1], res[i][j] + (a.charAt(i) == b.charAt(j) ? 0 : 1));
                }
            }
        }
        return res[a.length()][b.length()];
    }
 
	public static void main(String[] args) {
		String s = "aba";
		int mm = new RepeatString().minimalModify(s);
		System.out.println(mm);

	}
}


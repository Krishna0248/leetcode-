class Solution {
    static int solve(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 0;
        }

        if (i == s.length()) {
            return t.length() - j;
        }

        if (s.charAt(i) == t.charAt(j)) {
            return solve(s, t, i + 1, j + 1);
        }

        return solve(s, t, i + 1, j);
    }

    public int appendCharacters(String s, String t) {
        return solve(s, t, 0, 0);
    }
}

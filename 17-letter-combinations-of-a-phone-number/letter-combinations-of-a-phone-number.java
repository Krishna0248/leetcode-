class Solution {

    static void solve(String digits, String[] mapping,
                      List<String> result, int index,
                      StringBuilder output) {

        // Base case
        if (index >= digits.length()) {
            result.add(output.toString());
            return;
        }

        int values = digits.charAt(index) - '0';
        String mappedString = mapping[values];

        // Try every character
        for (int i = 0; i < mappedString.length(); i++) {

            output.append(mappedString.charAt(i));

            solve(digits, mapping, result, index + 1, output);

            // Backtracking
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        String[] mapping = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        StringBuilder output = new StringBuilder();

        solve(digits, mapping, result, 0, output);

        return result;
    }
}
class Solution {

    static void solve(int[] candidates, int target,
                      List<List<Integer>> ans,
                      List<Integer> output,
                      int index) {

        // Target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // No more candidates OR target became negative
        if (index >= candidates.length || target < 0) {
            return;
        }

        // Include current element
        output.add(candidates[index]);

        // Same index because we can reuse the same element
        solve(candidates, target - candidates[index],
              ans, output, index);

        // Backtrack
        output.remove(output.size() - 1);

        // Exclude current element
        solve(candidates, target, ans, output, index + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(candidates, target, ans, output, 0);

        return ans;
    }
}

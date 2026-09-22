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
              ans, output, index+1);

        // Backtrack
        output.remove(output.size() - 1);
        // exclude ke baad same element ko skip kar do
        // to generate unique
        while(index+1 < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }

        // Exclude current element
        solve(candidates, target, ans, output, index + 1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(candidates, target, ans, output, 0);

        return ans;
        
    }
}
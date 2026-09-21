class Solution {
    static void solve(int[] nums, int index, List<Integer> output,
                      List<List<Integer>> ans) {

        // Base case
        if (index >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Include
        output.add(nums[index]);
        solve(nums, index + 1, output, ans);

        // Backtracking
        output.remove(output.size() - 1);
        // while duplicate ignore
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        // Exclude
        solve(nums, index + 1, output, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(nums, 0, output, ans);

        return ans;
        
    }
}
class Solution {

    static void solve(int[] nums1, int[] nums2,
                      int i, int j, List<Integer> ans) {

        // Base case
        if (i >= nums1.length || j >= nums2.length) {
            return;
        }

        // Equal elements
        if (nums1[i] == nums2[j]) {
            ans.add(nums1[i]);

            solve(nums1, nums2, i + 1, j + 1, ans);
        }

        // nums1 ka element chhota hai
        else if (nums1[i] < nums2[j]) {
            solve(nums1, nums2, i + 1, j, ans);
        }

        // nums2 ka element chhota hai
        else {
            solve(nums1, nums2, i, j + 1, ans);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ans = new ArrayList<>();

        solve(nums1, nums2, 0, 0, ans);

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
class Solution {

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int[] positive = new int[n / 2];
        int[] negative = new int[n / 2];

        int p = 0;
        int ne = 0;

        
        for (int i = 0; i < n; i++) {

            if (nums[i] > 0) {
                positive[p++] = nums[i];
            } else {
                negative[ne++] = nums[i];
            }
        }

       
    

        p = 0;
        ne = 0;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                ans[i] = positive[p++];
            } else {
                ans[i] = negative[ne++];
            }
        }

        return ans;
    }
}
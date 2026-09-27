class Solution {

    static boolean solve(int[] arr, int index, boolean[] visited) {

        // Out of bounds
        if (index < 0 || index >= arr.length) {
            return false;
        }

        // Already visited
        if (visited[index]) {
            return false;
        }

        // Zero found
        if (arr[index] == 0) {
            return true;
        }

        // Mark current index
        visited[index] = true;

        // Move right
        boolean includeAns = solve(arr, index + arr[index], visited);

        // Move left
        boolean excludeAns = solve(arr, index - arr[index], visited);

        return includeAns || excludeAns;
    }

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return solve(arr, start, visited);
    }
}
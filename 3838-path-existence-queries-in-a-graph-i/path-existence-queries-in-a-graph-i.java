class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] prefix = new int[n];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if (Math.abs(nums[i] - nums[i - 1]) > maxDiff) {
                prefix[i]++;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l > r) {
                int temp = l;
                l = r;
                r = temp;
            }

            ans[i] = (prefix[r] == prefix[l]);
        }

        return ans;
    }
}
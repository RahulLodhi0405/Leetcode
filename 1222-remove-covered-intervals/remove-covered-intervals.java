class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = n;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        boolean[] covered = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!covered[j] &&
                    intervals[i][0] <= intervals[j][0] &&
                    intervals[i][1] >= intervals[j][1]) {
                    covered[j] = true;
                    count--;
                }
            }
        }

        return count;
    }
}
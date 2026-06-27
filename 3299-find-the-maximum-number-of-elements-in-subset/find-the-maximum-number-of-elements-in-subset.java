class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        if (freq.containsKey(1L)) {
            int c = freq.get(1L);
            ans = Math.max(ans, (c % 2 == 1) ? c : c - 1);
        }

        for (long start : freq.keySet()) {
            if (start == 1) continue;

            long cur = start;
            int len = 0;

            while (true) {
                Integer cnt = freq.get(cur);
                if (cnt == null) break;

                if (cnt >= 2) {
                    len += 2;
                    if (cur > (long) Math.sqrt(Long.MAX_VALUE)) break;
                    cur = cur * cur;
                } else {
                    len += 1;
                    break;
                }
            }

            if (len % 2 == 0) len--;
            ans = Math.max(ans, len);
        }

        return ans;
    }
}
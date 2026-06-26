class Solution {
    class Fenwick {
        int n;
        long[] bit;

        Fenwick(int size) {
            n = size;
            bit = new long[n + 1];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        Fenwick ft = new Fenwick(2 * n + 5);

        int shift = n + 2;
        int pref = 0;
        long ans = 0;

        ft.update(shift, 1); 

        for (int x : nums) {
            if (x == target)
                pref++;
            else
                pref--;

            int idx = pref + shift;
            ans += ft.query(idx - 1); 
            ft.update(idx, 1);
        }

        return ans;
    }
}
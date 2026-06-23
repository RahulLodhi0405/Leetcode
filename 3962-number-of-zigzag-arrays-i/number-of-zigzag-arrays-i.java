class Solution {
    static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        for (int i = 1; i <= m; i++) {
            up[i] = i - 1;
            down[i] = m - i;
        }

        for (int len = 3; len <= n; len++) {
            long[] nu = new long[m + 1];
            long[] nd = new long[m + 1];

            long[] pu = new long[m + 1];
            long[] pd = new long[m + 1];

            for (int i = 1; i <= m; i++) {
                pu[i] = (pu[i - 1] + up[i]) % MOD;
                pd[i] = (pd[i - 1] + down[i]) % MOD;
            }

            for (int i = 1; i <= m; i++) {
                nu[i] = pd[i - 1];
                nd[i] = (pu[m] - pu[i] + MOD) % MOD;
            }

            up = nu;
            down = nd;
        }

        long ans = 0;

        for (int i = 1; i <= m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}
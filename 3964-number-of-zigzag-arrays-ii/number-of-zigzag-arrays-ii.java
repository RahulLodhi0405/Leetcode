class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int sz = 2 * m;

        long[] base = new long[sz];

        for (int i = 0; i < m; i++) {
            base[i] = i;                 
            base[m + i] = m - 1 - i;    
        }

        long[][] T = new long[sz][sz];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                T[i][m + j] = 1; 
            }
            for (int j = i + 1; j < m; j++) {
                T[m + i][j] = 1; 
            }
        }

        long[][] P = matPow(T, n - 2);

        long[] res = multiply(P, base);

        long ans = 0;
        for (long x : res) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;
            for (int j = 0; j < n; j++) {
                cur = (cur + A[i][j] * v[j]) % MOD;
            }
            res[i] = cur;
        }

        return res;
    }

    private long[][] matPow(long[][] A, long e) {
        int n = A.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (e > 0) {
            if ((e & 1) == 1) {
                res = multiply(res, A);
            }
            A = multiply(A, A);
            e >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    res[i][j] =
                        (res[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}
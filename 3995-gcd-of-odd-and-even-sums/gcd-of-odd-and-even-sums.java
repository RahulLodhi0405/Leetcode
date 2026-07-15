class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        for (int i = 1; i <= 2 * n - 1; i += 2) {
            sumOdd += i;
        }

        int sumEven = 0;
        for (int i = 2; i <= 2 * n; i += 2) {
            sumEven += i;
        }

        int a = sumOdd, b = sumEven;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
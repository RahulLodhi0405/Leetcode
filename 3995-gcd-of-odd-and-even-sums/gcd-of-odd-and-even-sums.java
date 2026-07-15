class Solution {
    public int gcdOfOddEvenSums(int n) {
        int SumOdd=0;
        for(int i=1;i<n;i+=2){
            SumOdd+=n;
        }
int SumEven=0;
          for(int i=2;i<n;i+=2){
            SumEven+=n;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(SumOdd%n==0 && SumEven%n==0){
                ans=n;
            }
        }
        return ans;
    }
}
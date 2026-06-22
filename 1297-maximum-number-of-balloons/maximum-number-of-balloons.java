class Solution {
    public int maxNumberOfBalloons(String text) {
        int n=text.length();
        int ca=0;
        int cb=0;
        int cn=0;
        int cl=0;
        int co=0;
        int ans=0;
        int ans2=0;
        for(int i=0;i<n;i++){
            if(text.charAt(i)=='b'){
                cb++ ;
                }
        
        else if(text.charAt(i)=='a'){ca++ ;}

else if(text.charAt(i)=='l'){cl++;}

else if(text.charAt(i)=='o'){co++;}
        
        else if(text.charAt(i)=='n'){cn++;}
        else continue;
        
        }   
         ans=Math.min(ca,Math.min(cb,cn));
         ans2=Math.min(cl/2,co/2);     
    
        
       
       
    return Math.min(ans,ans2);
       
    }
}
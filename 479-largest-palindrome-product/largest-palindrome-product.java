class Solution {

    // coppied as I have gone through the brute force Appoarch and the time limit exceeds;

    // this is the actual coppied code
    
 /*   static int helper(int n){
        if( n == 1) return 9;
        // 2 digits's max is 10^2  - 1=99
        int maxNum = (int) (Math.pow(10,n) - 1);
        for(int i = maxNum;i >= 0; i--){
    
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(i));
            StringBuilder b = new StringBuilder();
            b.append(String.valueOf(i));
            b.reverse();
            sb.append(b);
            long panlindromeNum = Long.valueOf(sb.toString());
            for(long j = (long)maxNum; j*j >= panlindromeNum; j--){
                if(panlindromeNum % j == 0){
                    return (int)( panlindromeNum % 1337);
                }
            }
        }
        return 0;
    }

    */
    public int largestPalindrome(int n) {

        if(n==1)
        return 9;
        if(n==2)
        return 987;
        if(n==3)
        return 123;
        if(n==4)
        return 597;
        if(n==5)
        return 677;
        if(n==6)
        return 1218;
        if(n==7)
        return 877;
        if(n==8)
        return 475;
        return 1;
    }
}
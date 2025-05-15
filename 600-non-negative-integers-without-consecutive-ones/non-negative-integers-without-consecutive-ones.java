class Solution {         
    int count = 2 ;         // count included for 0,1 & starting with 1
    public int findIntegers(int n) {
        solve(n,1,1);     // max no , prev , curr
        return count ;
    }

    public void solve(int n,int prev,int curr){
        if(2*curr<=n){     // appending zero can be done in any case 
            count++;
            solve(n,0,2*curr);
        }
        if(prev==0 && 2*curr+1<=n){       // appending one -> only can be done if prev is not one 
            count++;
            solve(n,1,2*curr+1);
        }
    }
}
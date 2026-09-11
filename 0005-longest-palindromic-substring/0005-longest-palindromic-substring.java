class Solution {
    public boolean isPalindrome(String s,int i,int j, boolean[][] dp){
        //base case
        if(i>=j) return true;
        //memo
        if(dp[i][j] != false) return dp[i][j];
        //logic
        Boolean res = (s.charAt(i) == s.charAt(j) && isPalindrome(s,i+1,j-1,dp));
        dp[i][j] = res;
        return res; 
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int st = 0;
        int maxLen = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isPalindrome(s,i,j,dp) && (j-i+1) > maxLen){
                    st = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(st,st+maxLen);
    }
    
}
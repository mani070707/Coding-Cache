class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int st = 0;
        int maxLen = 0;
        boolean dp[][] = new boolean[n][n];
        
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(maxLen < (j-i+1)){
                        st = i;
                        maxLen = j-i+1;
                    }
                }
            }
        }

        return s.substring(st,st+maxLen);
    }
}
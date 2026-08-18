class Solution {
    public int helper(int idx,String s, int[] dp){
        if(idx == s.length()) return 1; //decoded the whole string
        if(s.charAt(idx) == '0') return 0; // 0 can'r be decoded

        if(dp[idx] != -1){
            return dp[idx];
        }

        int one = helper(idx+1,s,dp);
        int two = 0;
        if(idx + 1 < s.length()){
            int num = (s.charAt(idx)-'0')*10 + (s.charAt(idx+1)-'0');
            if(num<=26){
                two = helper(idx+2,s,dp);
            }
        }

        return dp[idx] = one + two;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return helper(0,s,dp);

        dp[n] = 1; // empty suffix - 1way

        for(int idx=n-1;idx>=0;idx--){
            if(s.charAt(idx) == '0') continue;
            int one = dp[idx+1];
            int two = 0;
            if(idx + 1 < s.length()){
                int num = (s.charAt(idx)-'0')*10 + (s.charAt(idx+1)-'0');
                if(num<=26){
                    two = dp[idx+2];
                }
            }

            dp[idx] = one + two;
        }
        return dp[0];

    }
}
class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        char[] s1 = s.toCharArray();
        int maxLen = 0;
        int[] freq = new int[26];
        int j=0;
        for(int i=0;i<n;i++){
            freq[s1[i] - 'a']++;
            
            while(freq[s1[i] - 'a'] > 2){
                    freq[s1[j] - 'a']--;
                    j++;
                }
                
            maxLen = Math.max(maxLen,i-j+1);
        }

        return maxLen;
    }
}
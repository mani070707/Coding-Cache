class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int j=0;
        for(int i=0;i<n;i++){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            else{
                //start from next idx of the prev start to check from that either u can find any other substring from that
                i = i-j;
                j=0;
            }
            if(j == m){
                return i-m+1;
            }
        }
        
        return -1;

    }
}
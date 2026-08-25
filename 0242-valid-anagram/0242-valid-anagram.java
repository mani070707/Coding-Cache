class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m){
            return false;
        }
        int[] arr = new int[26];

        for(int i=0;i<n;i++){
            int ch = s.charAt(i)-'a';
            arr[ch]++;
        }
        for(int i=0;i<m;i++){
            int ch = t.charAt(i)-'a';
            arr[ch]--;
        }
        for(int i=0;i<26;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
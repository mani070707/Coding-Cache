class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int maxi = Math.max(n1,n2);
        int mini = Math.min(n1,n2);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<mini;i++){
            sb.append(s1[i]);
            sb.append(s2[i]);
        }

        for(int i=mini;i<maxi;i++){
            if(n1>n2){
                sb.append(s1[i]);
            }
            else{
                sb.append(s2[i]);
            }
        }

        return sb.toString();
    }
}
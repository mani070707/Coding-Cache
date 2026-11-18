class Solution {
    public int minChanges(String s) {
        // substring to banani hai so hame string functions ka use krna hoga
        
        char curr = s.charAt(0);

        int cnt = 0;
        int minChanges = 0;

        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == curr){
                cnt++;
                continue;
            }

            if(cnt % 2 == 0){
                cnt = 1;
            }
            else{
                cnt = 0;
                minChanges++;
            }
            curr = s.charAt(i);
        }

        return minChanges;
    }
}
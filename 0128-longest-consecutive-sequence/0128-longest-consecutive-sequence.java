class Solution {
    public int longestConsecutive(int[] nums) {
  
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }

        int ans = 0;

        for(int n : numSet){
            if(!numSet.contains(n-1)){
                int len = 1;
                while(numSet.contains(n+len)){
                    len++;
                }
                ans = Math.max(ans,len);
            }
        }

        return ans;
    }
}
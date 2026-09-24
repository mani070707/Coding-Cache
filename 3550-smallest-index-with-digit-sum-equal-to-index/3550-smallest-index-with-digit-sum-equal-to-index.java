class Solution {
    public int helper(int x){
        int rem = 0;
        while(x>0){
            rem += x%10;
            x = x/10;
        }
        return rem;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int ans = 0;


        for(int i=0;i<n;i++){
            int dig = nums[i];
            if(nums[i] > 9){
                dig = helper(nums[i]);
            }
            if(dig == i){
                return i;
            }
            
        }
        return -1;
    }
}
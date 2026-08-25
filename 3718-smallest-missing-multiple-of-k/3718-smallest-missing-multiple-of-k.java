class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);

        int target = k;
        int j=2;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                target = k*j;
                j++;
            }
        }
        return target;
    }
}
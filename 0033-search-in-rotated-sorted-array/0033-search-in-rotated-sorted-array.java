class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                //left sorted
                if(nums[low] <= target && nums[mid] >= target){
                    high=mid-1;
                }
                else{
                    low = high+1;
                }
            }
            else{
                //right sorted
                if(nums[high] >= target && nums[mid] <= target){
                    low = mid + 1;
                }
                else{
                    high = mid-1;
                }
            }

        }

        return -1;
    }
}
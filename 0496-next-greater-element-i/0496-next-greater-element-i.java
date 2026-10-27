class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // nums1 is subset of num2 so it will always smaller in size

        int[] nextGreater = new int[10001];
        Stack<Integer> st = new Stack<>();

        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            nextGreater[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        for(int i=0;i<n;i++){
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }
}
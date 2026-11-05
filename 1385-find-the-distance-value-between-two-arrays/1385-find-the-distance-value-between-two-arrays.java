class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;
        int ans = 0;
        int sum=1;

        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                int validNo = Math.abs(arr1[i]-arr2[j]);
                if(validNo <= d){
                    sum=0;
                    break;
                }
            }
            ans+=sum;
            sum=1;

        }

        return ans;
    }
}
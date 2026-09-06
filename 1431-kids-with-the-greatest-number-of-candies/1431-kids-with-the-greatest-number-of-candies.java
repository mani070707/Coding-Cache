class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int n = candies.length;
        int maxi = 0;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,candies[i]);
        }
        for(int i=0;i<n;i++){
            if((candies[i] + extraCandies) >= maxi){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }

        return res;

    }
}
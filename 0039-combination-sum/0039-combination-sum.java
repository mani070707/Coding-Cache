class Solution {
    public void helper(int idx,int[] candidates,List<List<Integer>> ans,List<Integer> ds,int target){
        //base case
        if(idx == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //take case
        if(target >= candidates[idx]){
            ds.add(candidates[idx]);
            helper(idx,candidates,ans,ds,target-candidates[idx]);
            ds.remove(ds.size()-1);
        }
        //nontake
        helper(idx+1,candidates,ans,ds,target);


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        helper(0,candidates,ans,ds,target);
        return ans;
    }
}
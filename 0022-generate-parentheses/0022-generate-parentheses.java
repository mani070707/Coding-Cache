class Solution {
    public void helper(int open, int close, int n ,List<String> ds , String path){
        //base case
        if(open == close && (open + close == 2*n)){
            ds.add(path);
            return;
        }

        if(open<n) helper(open+1,close,n,ds,path +'(');
        if(close<open) helper(open,close+1,n,ds,path+')');
    }
    public List<String> generateParenthesis(int n) {
        //well formed parentheses
        // ((())) -> (()()) , ()(()), (())(), ()()()
        //recursive -> lets take 2 idx open close

        List<String> ds = new ArrayList<>();
        helper(0,0,n,ds,"");
        return ds;
    }
}
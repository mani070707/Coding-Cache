class Solution {
    public int scoreOfParentheses(String s) {
        // we have 23 rule
        //main task in find the right cond to select right rule

        //stack
        //2 rule -> after poping stack will not remain empty
        //3 rule -> after poping stack will remain empty

        Stack<Integer> st = new Stack<>();

        int res = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.add(res);
                res = 0;
            }
            else{
                res = st.pop() + Math.max(res*2, 1);
            }
        }

        return res;

    }
}
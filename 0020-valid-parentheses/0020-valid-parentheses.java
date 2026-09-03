class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] st = s.toCharArray();

        for(int i=0;i<st.length;i++){
            if(st[i] == '(' || st[i] == '{' || st[i] == '['){
                stack.push(st[i]);
            }
            else{
                if(stack.isEmpty()) return false;
                char top = stack.peek();
                if((top == '(' && st[i] == ')') || (top == '{' && st[i] == '}') || (top == '[' && st[i] == ']')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
}
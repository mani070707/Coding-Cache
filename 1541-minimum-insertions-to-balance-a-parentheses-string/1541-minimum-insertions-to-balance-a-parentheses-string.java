class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                // A closing bracket must be part of a "))" pair.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'.
                } else {
                    insertions++; // Insert the missing second ')'.
                }

                if (open > 0) {
                    open--;
                } else {
                    // Insert a matching '(' before the "))".
                    insertions++;
                }
            }
        }

        // Every unmatched '(' requires two closing brackets.
        return insertions + open * 2;
    }
}
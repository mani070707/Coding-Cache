class Solution {
    private Map<String, Integer> dist = new HashMap<>();
    private List<List<String>> ans = new ArrayList<>();
    private String beginWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        Set<String> st = new HashSet<>(wordList);

        // ---------- Step 1: BFS se distance map ----------
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        dist.put(beginWord, 1);
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = dist.get(word);

            if (word.equals(endWord)) break;   // end mil gaya, aage nahi

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if (st.contains(newWord)) {
                        q.add(newWord);
                        st.remove(newWord);
                        dist.put(newWord, steps + 1);
                    }
                }
            }
        }

        // ---------- Step 2: endWord se DFS (ulta) ----------
        if (dist.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path);
        }
        return ans;
    }

    private void dfs(String word, List<String> path) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);          // ulta bana tha, seedha karo
            ans.add(temp);
            return;
        }

        int steps = dist.get(word);

        for (int i = 0; i < word.length(); i++) {
            char[] arr = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String prev = new String(arr);

                // sirf wahi prev jo ek step peeche ho
                if (dist.containsKey(prev) && dist.get(prev) == steps - 1) {
                    path.add(prev);
                    dfs(prev, path);
                    path.remove(path.size() - 1);   // backtrack
                }
            }
        }
    }
}
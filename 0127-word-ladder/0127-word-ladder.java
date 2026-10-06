class Pair{
    String first;
    int second;
    
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(beginWord,1)); // startword,steps
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();

            //check the find cond
            if(word.equals(endWord)){
                return steps;
            }

            for(int i=0;i<word.length();i++){
                char[] arr = word.toCharArray();
                char original = arr[i];
                for(char ch='a' ; ch<='z' ;ch++){
                    arr[i] = ch;                          // 1. change one letter
                    String newWord = new String(arr);     // 2. convert char[] back to String
                    if(st.contains(newWord)){             // 3. is it a valid word in the list?
                        st.remove(newWord);               // 4. mark visited (remove from set)
                        q.add(new Pair(newWord,steps+1)); // 5. one more step in the ladder
                    }
                    arr[i] = original;                    // 6. restore, so the next ch starts clean
                }
            }
        }

        return 0;

    }
}
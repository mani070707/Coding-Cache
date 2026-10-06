class Pair{
    String first;
    int second;
    public Pair(String first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                char[] arr = word.toCharArray();
                char original = arr[i];
                for(char ch = 'a'; ch<='z' ; ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                    }
                    arr[i] = original;
                }
                
            }
        }

        return 0;
   
        

    }
}
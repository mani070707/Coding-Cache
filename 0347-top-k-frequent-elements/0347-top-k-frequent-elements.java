class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> cnt = new HashMap<>();

        for(int num : nums){
            cnt.put(num,cnt.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];

        for(int key : cnt.keySet()){
            int freq = cnt.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();

            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;
        for(int i = n; i>=0 && idx<k;i--){
            if(bucket[i] != null){
                for(int it : bucket[i]){
                    ans[idx++] = it;
                }
            }
        }

        return ans;

    }
}
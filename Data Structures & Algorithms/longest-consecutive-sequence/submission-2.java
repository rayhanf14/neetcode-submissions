class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int ans = 0;
        for(Integer n: set){
            if(!set.contains(n - 1)){
                int res = 1;
                n += 1;
                while(set.contains(n)){
                    res += 1;
                    n += 1;
                }
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
}

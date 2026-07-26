class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, target,new ArrayList<>(), ans);
        return ans;
    }
    void helper(int ind, int[] nums,int target, List<Integer> cur, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(cur));
        }
        if(target < 0){
            return;
        }
        for(int i = ind; i < nums.length; i++){
            cur.add(nums[i]);
            helper(i, nums, target - nums[i], cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}

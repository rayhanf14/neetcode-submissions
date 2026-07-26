class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> seen = new ArrayList<>();
        for(int x : nums){
            if(seen.contains(x)){
                return true;
            }
            if(!seen.contains(x)){
                seen.add(x);
            }
        }
        return false;
    }
}
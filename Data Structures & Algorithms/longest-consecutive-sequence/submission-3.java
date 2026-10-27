
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int x = num;
                int count = 1;

                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }

                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}

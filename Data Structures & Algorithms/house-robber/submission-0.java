class Solution {
    public int rob(int[] nums) {
        int[] h = new int[nums.length + 1];
        System.arraycopy(nums, 0, h, 1, nums.length);

        int[] f = new int[nums.length + 1];
        f[1] = h[1];

        for (int i = 2; i < h.length; i++) {
            f[i] = Math.max(h[i] + f[i - 2], f[i - 1]);
        }

        return f[f.length - 1];
    }
}
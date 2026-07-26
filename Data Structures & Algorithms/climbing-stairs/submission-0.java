class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int ans = climb(dp, n);
        return ans;
    }
    int climb(int[] dp, int n){
        if(n == 0 || n == 1 || n == 2){
            return n;
        }
        if(dp[n] != 0) return dp[n];
        int ans = climb(dp, n - 1) + climb(dp, n - 2);
        dp[n] = ans;
        return ans;
    }

}

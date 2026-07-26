class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        while n > 0:
            ans += n & 1   # check last bit
            n >>= 1        # shift right
        return ans
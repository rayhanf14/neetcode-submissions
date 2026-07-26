class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        self.calc(nums, [], target, 0, res)
        return res

    def calc(self, nums: List[int], ans: List[int], req: int, ind: int, res: List[List[int]]):
        if req == 0:
            res.append(ans[:])  # found a valid combination
            return
        if req < 0 or ind == len(nums):
            return
        # include current number
        ans.append(nums[ind])
        self.calc(nums, ans, req - nums[ind], ind, res)
        ans.pop()  # backtrack

        # skip current number
        self.calc(nums, ans, req, ind + 1, res)
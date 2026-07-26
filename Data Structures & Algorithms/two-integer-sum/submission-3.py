class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr = [(num, i) for i, num in enumerate(nums)]
        arr.sort()  # sort by value

        left, right = 0, len(arr) - 1
        while left < right:
            s = arr[left][0] + arr[right][0]
            if s == target:
                i, j = arr[left][1], arr[right][1]
                return [min(i, j), max(i, j)]  # ensure smaller index first
            elif s < target:
                left += 1
            else:
                right -= 1
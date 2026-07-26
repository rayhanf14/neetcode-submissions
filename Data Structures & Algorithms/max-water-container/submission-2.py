class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left = 0
        right = len(heights) - 1
        ans = 0
        while(left < right):
            if(heights[left] == 0 or heights[right] == 0):
                area = 0
            small = min(heights[left], heights[right])
            area = small * abs(left - right)
            if(area > ans):
                ans = area
            if(small == heights[left]):
                left += 1
            else:
                right -= 1
        return ans
        
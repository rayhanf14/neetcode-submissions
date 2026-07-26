class Solution:
    def minWindow(self, s: str, t: str) -> str:
        def check(sub_count, need):
            for key in need:
                if sub_count[key] < need[key]:
                    return False
            return True

        need = Counter(t)
        window = Counter()

        left = 0
        ans = ""
        min_len = float("inf")

        for right in range(len(s)):
            window[s[right]] += 1
            while check(window, need):
                #update ans first so that a possible ans is not lost cuz of shrinking first
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    ans = s[left:right+1]

                window[s[left]] -= 1
                left += 1

        return ans
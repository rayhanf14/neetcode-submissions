class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False
        chars = list(s)
        for ch in t:
            if(ch not in chars):
                return False
            if(ch in chars):
                chars.remove(ch)
        return True
        
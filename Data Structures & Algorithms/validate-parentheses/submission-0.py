class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        p = 0
        while p < len(s):
            if s[p] == '(' or s[p] == '[' or s[p] == '{':
                stack.append(s[p])
            elif s[p] == ')':
                if not stack or stack[-1] != '(':
                    return False
                stack.pop()
            elif s[p] == ']':
                if not stack or stack[-1] != '[':
                    return False
                stack.pop()
            elif s[p] == '}':
                if not stack or stack[-1] != '{':
                    return False
                stack.pop()
            p += 1
        
        # stack must be empty at the end
        return not stack
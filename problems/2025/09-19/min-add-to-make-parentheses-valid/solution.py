class Solution:
    def minParentheses(self, s: str) -> int:
        open_needed = 0
        insertions = 0
        for ch in s:
            if ch == '(':
                open_needed += 1
            else:
                if open_needed > 0:
                    open_needed -= 1
                else:
                    insertions += 1
        return insertions + open_needed

if __name__ == "__main__":
    sol = Solution()
    print(sol.minParentheses("(()("))  # 2
    print(sol.minParentheses(")))"))   # 3
    print(sol.minParentheses(")()()")) # 1

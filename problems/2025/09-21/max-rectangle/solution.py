from typing import List

class Solution:
    def maxArea(self, mat: List[List[int]]) -> int:
        if not mat or not mat[0]:
            return 0
        r, c = len(mat), len(mat[0])
        heights = [0] * c
        ans = 0
        for i in range(r):
            for j in range(c):
                if mat[i][j] == 1:
                    heights[j] += 1
                else:
                    heights[j] = 0
            # largest rectangle in histogram
            st = []
            for k in range(c + 1):
                h = heights[k] if k < c else 0
                while st and heights[st[-1]] > h:
                    ht = heights[st.pop()]
                    left = st[-1] if st else -1
                    width = k - left - 1
                    area = ht * width
                    if area > ans:
                        ans = area
                st.append(k)
        return ans

if __name__ == "__main__":
    sol = Solution()
    print(sol.maxArea([[0,1,1,0],[1,1,1,1],[1,1,1,1],[1,1,0,0]]))  # 8
    print(sol.maxArea([[0,1,1],[1,1,1],[0,1,1]]))                # 6

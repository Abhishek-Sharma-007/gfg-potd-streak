from typing import List

class Solution:
    def maxOfMins(self, arr: List[int]) -> List[int]:
        n = len(arr)
        prev = [-1] * n
        next_ = [n] * n
        st = []
        # previous smaller (strict)
        for i in range(n):
            while st and arr[st[-1]] >= arr[i]:
                st.pop()
            prev[i] = st[-1] if st else -1
            st.append(i)
        st.clear()
        # next smaller (strict)
        for i in range(n - 1, -1, -1):
            while st and arr[st[-1]] > arr[i]:
                st.pop()
            next_[i] = st[-1] if st else n
            st.append(i)
        res = [0] * n
        for i in range(n):
            length = next_[i] - prev[i] - 1
            # window size 'length' (1-indexed) maps to res[length-1]
            idx = length - 1
            if arr[i] > res[idx]:
                res[idx] = arr[i]
        # fill from right to left
        for i in range(n - 2, -1, -1):
            if res[i] < res[i + 1]:
                res[i] = res[i + 1]
        return res

if __name__ == "__main__":
    sol = Solution()
    print(sol.maxOfMins([10,20,30,50,10,70,30]))  # [70,30,20,10,10,10,10]
    print(sol.maxOfMins([10,20,30]))              # [30,20,10]

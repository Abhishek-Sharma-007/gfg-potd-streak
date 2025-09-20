from typing import List

class Solution:
    def longestSubarray(self, arr: List[int]) -> int:
        n = len(arr)
        left = [-1] * n
        right = [n] * n
        st = []
        # Strict greater for boundaries, so equal values can be inside span
        for i in range(n):
            while st and arr[st[-1]] <= arr[i]:
                st.pop()
            left[i] = st[-1] if st else -1
            st.append(i)
        st.clear()
        for i in range(n - 1, -1, -1):
            while st and arr[st[-1]] < arr[i]:
                st.pop()
            right[i] = st[-1] if st else n
            st.append(i)
        ans = 0
        for i in range(n):
            span = right[i] - left[i] - 1
            if span >= arr[i]:
                if span > ans:
                    ans = span
        return ans

if __name__ == "__main__":
    sol = Solution()
    print(sol.longestSubarray([1,2,3]))      # 3
    print(sol.longestSubarray([6,4,2,5]))    # 0

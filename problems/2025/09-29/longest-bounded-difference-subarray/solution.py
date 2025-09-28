from collections import deque
from typing import List

class Solution:
    def longestSubarray(self, arr: List[int], x: int) -> List[int]:
        n = len(arr)
        maxdq, mindq = deque(), deque()
        best_len = 0
        best_l = 0
        l = 0
        for r in range(n):
            while maxdq and arr[maxdq[-1]] < arr[r]:
                maxdq.pop()
            maxdq.append(r)
            while mindq and arr[mindq[-1]] > arr[r]:
                mindq.pop()
            mindq.append(r)
            while arr[maxdq[0]] - arr[mindq[0]] > x:
                if maxdq[0] == l:
                    maxdq.popleft()
                if mindq[0] == l:
                    mindq.popleft()
                l += 1
            cur_len = r - l + 1
            if cur_len > best_len:
                best_len = cur_len
                best_l = l
        return arr[best_l:best_l + best_len]

if __name__ == "__main__":
    sol = Solution()
    print(sol.longestSubarray([8,4,5,6,7], 3))  # [4,5,6,7]
    print(sol.longestSubarray([1,10,12,13,14], 2))  # [12,13,14]

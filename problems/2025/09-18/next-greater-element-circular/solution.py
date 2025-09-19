from typing import List

def next_greater(arr: List[int]) -> List[int]:
    n = len(arr)
    ans = [-1] * n
    stack: List[int] = []  # indices with decreasing values
    for i in range(2 * n - 1, -1, -1):
        j = i % n
        while stack and arr[stack[-1]] <= arr[j]:
            stack.pop()
        if i < n and stack:
            ans[j] = arr[stack[-1]]
        stack.append(j)
    return ans

if __name__ == "__main__":
    print(next_greater([1,3,2,4]))        # [3,4,4,-1]
    print(next_greater([0,2,3,1,1]))      # [2,3,-1,2,2]


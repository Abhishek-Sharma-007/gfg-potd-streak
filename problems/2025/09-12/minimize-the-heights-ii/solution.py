from typing import List

def minimize_heights(arr: List[int], k: int) -> int:
    n = len(arr)
    if n <= 1:
        return 0
    arr.sort()
    ans = arr[-1] - arr[0]
    small = arr[0] + k
    big = arr[-1] - k
    if small > big:
        small, big = big, small
    for i in range(1, n - 1):
        decrease = arr[i] - k
        increase = arr[i] + k
        if decrease < 0:
            continue
        cur_min = small if small < decrease else decrease
        cur_max = big if big > increase else increase
        if cur_max - cur_min < ans:
            ans = cur_max - cur_min
    return ans

if __name__ == "__main__":
    print(minimize_heights([1,5,8,10], 2))  # 5
    print(minimize_heights([3,9,12,16,20], 3))  # 11



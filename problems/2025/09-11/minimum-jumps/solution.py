from typing import List


def min_jumps(arr: List[int]) -> int:
    n = len(arr)
    if n <= 1:
        return 0
    if arr[0] == 0:
        return -1

    jumps = 0
    end = 0
    farthest = 0

    for i in range(n - 1):
        if i > farthest:
            return -1
        farthest = max(farthest, i + arr[i])
        if i == end:
            jumps += 1
            end = farthest
            if end >= n - 1:
                return jumps
    return -1 if end < n - 1 else jumps


if __name__ == "__main__":
    print(min_jumps([1,3,5,8,9,2,6,7,6,8,9]))  # 3
    print(min_jumps([1,4,3,2,6,7]))            # 2
    print(min_jumps([0,10,20]))                # -1

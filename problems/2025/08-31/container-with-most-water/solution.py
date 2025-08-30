from typing import List


def max_area(arr: List[int]) -> int:
    n = len(arr)
    if n < 2:
        return 0
    left, right = 0, n - 1
    best = 0
    while left < right:
        height = arr[left] if arr[left] < arr[right] else arr[right]
        area = (right - left) * height
        if area > best:
            best = area
        if arr[left] < arr[right]:
            left += 1
        else:
            right -= 1
    return best


if __name__ == "__main__":
    print(max_area([1,5,4,3]))             # 6
    print(max_area([3,1,2,4,5]))           # 12
    print(max_area([2,1,8,6,4,6,5,5]))     # 25



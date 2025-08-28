def max_consecutive_ones(arr, k):
    left = 0
    zeros = 0
    best = 0
    for right, val in enumerate(arr):
        if val == 0:
            zeros += 1
        while zeros > k:
            if arr[left] == 0:
                zeros -= 1
            left += 1
        best = max(best, right - left + 1)
    return best


if __name__ == "__main__":
    print(max_consecutive_ones([1, 0, 1], 1))                         # 3
    print(max_consecutive_ones([1, 0, 0, 1, 0, 1, 0, 1], 2))          # 5
    print(max_consecutive_ones([1, 1], 2))                             # 2

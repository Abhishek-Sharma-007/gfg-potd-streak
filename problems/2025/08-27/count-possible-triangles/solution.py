from typing import List

def count_triangles(arr: List[int]) -> int:
    n = len(arr)
    if n < 3: return 0
    arr.sort()
    count = 0
    for k in range(n-1, 1, -1):
        i, j = 0, k-1
        while i < j:
            if arr[i] + arr[j] > arr[k]:
                count += (j - i)
                j -= 1
            else:
                i += 1
    return count

if __name__ == "__main__":
    print(count_triangles([4,6,3,7]))                           # 3
    print(count_triangles([10,21,22,100,101,200,300]))          # 6
    print(count_triangles([1,2,3]))                             # 0



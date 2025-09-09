from typing import List


def assign_hole(mices: List[int], holes: List[int]) -> int:
    n = len(mices)
    if n == 0:
        return 0
    mices.sort()
    holes.sort()
    best = 0
    for i in range(n):
        d = abs(mices[i] - holes[i])
        if d > best:
            best = d
    return best


if __name__ == "__main__":
    print(assign_hole([4, -4, 2], [4, 0, 5]))  # 4
    print(assign_hole([1, 2], [20, 10]))       # 18

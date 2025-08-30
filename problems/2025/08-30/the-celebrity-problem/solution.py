from typing import List


def celebrity(mat: List[List[int]]) -> int:
    n = len(mat)
    if n == 0:
        return -1

    i, j = 0, n - 1
    while i < j:
        if mat[i][j] == 1:
            i += 1
        else:
            j -= 1

    cand = i

    for k in range(n):
        if k == cand:
            continue
        if mat[cand][k] == 1 or mat[k][cand] == 0:
            return -1

    return cand


if __name__ == "__main__":
    print(celebrity([[1,1,0],[0,1,0],[0,1,1]]))  # 1
    print(celebrity([[1,1],[1,1]]))              # -1
    print(celebrity([[1]]))                      # 0



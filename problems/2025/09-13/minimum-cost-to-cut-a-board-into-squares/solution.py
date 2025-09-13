from typing import List

def min_cost_to_cut_board(x: List[int], y: List[int]) -> int:
    x.sort(reverse=True)
    y.sort(reverse=True)
    i = j = 0
    h_segments = 1  # horizontal pieces count
    v_segments = 1  # vertical pieces count
    total = 0
    while i < len(x) and j < len(y):
        if x[i] >= y[j]:
            total += x[i] * h_segments
            v_segments += 1
            i += 1
        else:
            total += y[j] * v_segments
            h_segments += 1
            j += 1
    while i < len(x):
        total += x[i] * h_segments
        v_segments += 1
        i += 1
    while j < len(y):
        total += y[j] * v_segments
        h_segments += 1
        j += 1
    return total

if __name__ == "__main__":
    print(min_cost_to_cut_board([2,1,3,1,4], [4,1,2]))  # 42
    print(min_cost_to_cut_board([1,1,1], [1,1,1]))      # 15



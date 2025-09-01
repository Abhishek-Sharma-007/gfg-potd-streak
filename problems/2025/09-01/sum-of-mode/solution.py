from typing import List
import heapq


def sum_of_modes(arr: List[int], k: int) -> int:
    n = len(arr)
    if k <= 0 or k > n:
        return 0

    # Frequency map
    cnt: dict[int, int] = {}
    # Heap of tuples: (-freq, value)
    heap: list[tuple[int, int]] = []

    def push_value(val: int, new_freq: int) -> None:
        heapq.heappush(heap, (-new_freq, val))

    # Build first window
    for i in range(k):
        v = arr[i]
        f = cnt.get(v, 0) + 1
        cnt[v] = f
        push_value(v, f)

    # Get mode value by cleaning outdated heap entries lazily
    def current_mode_value() -> int:
        while heap:
            negf, v = heap[0]
            if cnt.get(v, 0) == -negf:
                return v
            heapq.heappop(heap)
        return 0

    total = current_mode_value()

    # Slide window
    for r in range(k, n):
        out = arr[r - k]
        in_v = arr[r]

        # Decrease outgoing
        f_out = cnt.get(out, 0)
        if f_out > 0:
            cnt_out_new = f_out - 1
            if cnt_out_new == 0:
                del cnt[out]
            else:
                cnt[out] = cnt_out_new
                push_value(out, cnt_out_new)

        # Increase incoming
        f_in = cnt.get(in_v, 0) + 1
        cnt[in_v] = f_in
        push_value(in_v, f_in)

        total += current_mode_value()

    return int(total)


if __name__ == "__main__":
    print(sum_of_modes([1, 2, 3, 2, 5, 2, 4, 4], 3))  # 13
    print(sum_of_modes([1, 2, 1, 3, 5], 2))           # 6



from collections import Counter


def smallest_window(s: str, p: str) -> str:
    if not p or not s or len(p) > len(s):
        return ""

    need = Counter(p)
    have = 0
    required = len(need)
    left = 0
    best_len = float('inf')
    best_l = 0

    window = Counter()

    for right, ch in enumerate(s):
        if ch in need:
            window[ch] += 1
            if window[ch] == need[ch]:
                have += 1

        while have == required:
            curr_len = right - left + 1
            if curr_len < best_len:
                best_len = curr_len
                best_l = left

            left_ch = s[left]
            if left_ch in need:
                window[left_ch] -= 1
                if window[left_ch] < need[left_ch]:
                    have -= 1
            left += 1

    return s[best_l:best_l + best_len] if best_len != float('inf') else ""


if __name__ == "__main__":
    print(smallest_window("timetopractice", "toc"))  # toprac
    print(smallest_window("zoomlazapzo", "oza"))     # apzo
    print(smallest_window("zoom", "zooe"))           # ""



def largest_one_swap(s: str) -> str:
    n = len(s)
    if n <= 1:
        return s

    # posMax[i] = index of rightmost maximum digit in s[i:]
    posMax = [0] * n
    posMax[-1] = n - 1
    for i in range(n - 2, -1, -1):
        if s[i] > s[posMax[i + 1]]:
            posMax[i] = i
        elif s[i] < s[posMax[i + 1]]:
            posMax[i] = posMax[i + 1]
        else:
            # same digit; prefer rightmost occurrence
            posMax[i] = posMax[i + 1]

    s_list = list(s)
    for i in range(n):
        j = posMax[i]
        if s_list[j] > s_list[i]:
            s_list[i], s_list[j] = s_list[j], s_list[i]
            break
    return ''.join(s_list)


if __name__ == "__main__":
    print(largest_one_swap("768"))  # 867
    print(largest_one_swap("333"))  # 333
    print(largest_one_swap("12345"))  # 52341

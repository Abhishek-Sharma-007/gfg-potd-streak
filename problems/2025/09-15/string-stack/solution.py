def string_stack(pat: str, tar: str) -> bool:
    j = 0
    for ch in pat:
        if j < len(tar) and ch == tar[j]:
            j += 1
    return j == len(tar)

if __name__ == "__main__":
    print(string_stack("geuaek", "geek"))      # True
    print(string_stack("agiffghd", "gfg"))     # True
    print(string_stack("ufahs", "aus"))        # False

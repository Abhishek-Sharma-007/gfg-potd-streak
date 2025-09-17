def decode_string(s: str) -> str:
    num_stack = []
    str_stack = []
    curr = []
    num = 0
    for ch in s:
        if ch.isdigit():
            num = num * 10 + (ord(ch) - 48)
        elif ch == '[':
            num_stack.append(num)
            str_stack.append(''.join(curr))
            num = 0
            curr = []
        elif ch == ']':
            k = num_stack.pop()
            prev = str_stack.pop()
            curr = [prev + ''.join(curr) * k]
        else:
            curr.append(ch)
    return ''.join(curr)

if __name__ == "__main__":
    print(decode_string("3[b2[ca]]"))  # bcacabcacabcaca
    print(decode_string("3[ab]"))     # ababab

from typing import List
import math

def evaluate_postfix(arr: List[str]) -> int:
    stack: List[int] = []
    for tok in arr:
        if tok in {"+", "-", "*", "/", "^"}:
            b = stack.pop()
            a = stack.pop()
            if tok == "+":
                stack.append(a + b)
            elif tok == "-":
                stack.append(a - b)
            elif tok == "*":
                stack.append(a * b)
            elif tok == "/":
                # floor division toward -infinity
                stack.append(math.floor(a / b))
            else:  # ^
                stack.append(int(pow(a, b)))
        else:
            stack.append(int(tok))
    return stack[-1]

if __name__ == "__main__":
    print(evaluate_postfix(["2","3","1","*","+","9","-"]))  # -4
    print(evaluate_postfix(["2","3","^","1","+"]))              # 9

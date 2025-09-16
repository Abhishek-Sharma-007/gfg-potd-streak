function evaluatePostfix(arr) {
  const st = [];
  for (const tok of arr) {
    if (tok === "+" || tok === "-" || tok === "*" || tok === "/" || tok === "^") {
      const b = st.pop();
      const a = st.pop();
      switch (tok) {
        case "+": st.push(a + b); break;
        case "-": st.push(a - b); break;
        case "*": st.push(a * b); break;
        case "/": {
          // floor division toward -infinity
          const q = Math.floor(a / b);
          st.push(q);
          break;
        }
        case "^": st.push(Math.pow(a, b) | 0); break;
      }
    } else {
      st.push(parseInt(tok, 10));
    }
  }
  return st[st.length - 1];
}

console.log(evaluatePostfix(["2","3","1","*","+","9","-"])); // -4
console.log(evaluatePostfix(["2","3","^","1","+"]));             // 9

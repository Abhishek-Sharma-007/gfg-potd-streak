function decodeString(s) {
  const numStack = [];
  const strStack = [];
  let curr = '';
  let num = 0;
  for (const ch of s) {
    if (ch >= '0' && ch <= '9') {
      num = num * 10 + (ch.charCodeAt(0) - 48);
    } else if (ch === '[') {
      numStack.push(num);
      strStack.push(curr);
      num = 0;
      curr = '';
    } else if (ch === ']') {
      const k = numStack.pop();
      const prev = strStack.pop();
      curr = prev + curr.repeat(k);
    } else {
      curr += ch;
    }
  }
  return curr;
}

console.log(decodeString("3[b2[ca]]")); // bcacabcacabcaca
console.log(decodeString("3[ab]"));    // ababab

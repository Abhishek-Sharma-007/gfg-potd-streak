function stringStack(pat, tar) {
  let j = 0;
  for (let i = 0; i < pat.length; i++) {
    if (j < tar.length && pat[i] === tar[j]) {
      j++;
    }
  }
  return j === tar.length;
}

console.log(stringStack("geuaek", "geek"));    // true
console.log(stringStack("agiffghd", "gfg"));   // true
console.log(stringStack("ufahs", "aus"));      // false

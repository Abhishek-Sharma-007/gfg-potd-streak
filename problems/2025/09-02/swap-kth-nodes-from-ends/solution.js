function Node(x) {
  this.data = x;
  this.next = null;
}

function swapKth(head, k) {
  if (!head || k <= 0) return head;

  // 1) Find length n
  let n = 0, t = head;
  while (t) { n++; t = t.next; }
  if (k > n) return head;

  let i1 = k;
  let i2 = n - k + 1;
  if (i1 === i2) return head;
  if (i1 > i2) { const tmp = i1; i1 = i2; i2 = tmp; }

  // 2) Find (prev1, node1) and (prev2, node2)
  let prev1 = null, node1 = head;
  for (let i = 1; i < i1; i++) { prev1 = node1; node1 = node1.next; }

  let prev2 = null, node2 = head;
  for (let i = 1; i < i2; i++) { prev2 = node2; node2 = node2.next; }

  // 3) Rewire
  if (prev1) prev1.next = node2; else head = node2;
  if (prev2) prev2.next = node1; else head = node1;

  // 4) Swap next pointers
  const temp = node1.next;
  node1.next = node2.next;
  node2.next = temp;

  return head;
}

// Helpers
function buildList(arr) {
  let head = null, tail = null;
  for (const v of arr) {
    const n = new Node(v);
    if (!head) { head = tail = n; }
    else { tail.next = n; tail = n; }
  }
  return head;
}

function toArray(head) {
  const out = [];
  while (head) { out.push(head.data); head = head.next; }
  return out;
}

// quick checks
let h = buildList([1,2,3,4,5]);
h = swapKth(h, 1);
console.log(toArray(h)); // [5,2,3,4,1]

h = buildList([3,10,5,8,9,5]);
h = swapKth(h, 2);
console.log(toArray(h)); // [3,9,5,8,10,5]

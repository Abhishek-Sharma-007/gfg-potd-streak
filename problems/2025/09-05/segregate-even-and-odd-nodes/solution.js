function Node(d) {
  this.data = d;
  this.next = null;
}

function segregate(head) {
  if (!head || !head.next) return head;

  let evenHead = null, evenTail = null;
  let oddHead = null, oddTail = null;

  let curr = head;
  while (curr) {
    const nxt = curr.next;
    curr.next = null;
    if ((curr.data & 1) === 0) {
      if (!evenHead) { evenHead = evenTail = curr; }
      else { evenTail.next = curr; evenTail = curr; }
    } else {
      if (!oddHead) { oddHead = oddTail = curr; }
      else { oddTail.next = curr; oddTail = curr; }
    }
    curr = nxt;
  }

  if (!evenHead) return oddHead;
  evenTail.next = oddHead;
  return evenHead;
}

// Helpers
function buildList(arr) {
  let head = null, tail = null;
  for (const v of arr) {
    const n = new Node(v);
    if (!head) head = tail = n;
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
let h = buildList([17,15,8,9,2,4,6]);
h = segregate(h);
console.log(toArray(h)); // [8,2,4,6,17,15,9]

h = buildList([1,3,5]);
h = segregate(h);
console.log(toArray(h)); // [1,3,5]

h = buildList([2,4,6]);
h = segregate(h);
console.log(toArray(h)); // [2,4,6]

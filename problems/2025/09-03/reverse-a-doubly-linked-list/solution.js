function Node(data) {
  this.data = data;
  this.next = null;
  this.prev = null;
}

function reverse(head) {
  if (!head || !head.next) return head;

  let curr = head;
  let temp = null;

  while (curr) {
    temp = curr.prev;
    curr.prev = curr.next;
    curr.next = temp;
    curr = curr.prev; // move to new prev (originally next)
  }

  if (temp) head = temp.prev;
  return head;
}

// Helpers
function buildDLL(arr) {
  let head = null, prev = null;
  for (const v of arr) {
    const n = new Node(v);
    if (!head) head = n;
    if (prev) { prev.next = n; n.prev = prev; }
    prev = n;
  }
  return head;
}

function toArray(head) {
  const out = [];
  while (head) { out.push(head.data); head = head.next; }
  return out;
}

// quick checks
let h = buildDLL([3,4,5]);
h = reverse(h);
console.log(toArray(h)); // [5,4,3]

h = buildDLL([75,122,59,196]);
h = reverse(h);
console.log(toArray(h)); // [196,59,122,75]

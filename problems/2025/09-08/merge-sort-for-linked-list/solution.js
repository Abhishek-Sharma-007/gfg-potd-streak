function Node(d) {
  this.data = d;
  this.next = null;
}

function sortList(head) {
  return mergeSort(head);
}

function mergeSort(head) {
  if (!head || !head.next) return head;
  const midPrev = midPrevNode(head);
  const mid = midPrev.next;
  midPrev.next = null;
  const left = mergeSort(head);
  const right = mergeSort(mid);
  return merge(left, right);
}

function midPrevNode(head) {
  let slow = head, fast = head, prev = null;
  while (fast && fast.next) { prev = slow; slow = slow.next; fast = fast.next.next; }
  return prev;
}

function merge(a, b) {
  const dummy = new Node(0);
  let tail = dummy;
  while (a && b) {
    if (a.data <= b.data) { tail.next = a; a = a.next; }
    else { tail.next = b; b = b.next; }
    tail = tail.next;
  }
  tail.next = a ? a : b;
  return dummy.next;
}

// Helpers
function buildList(arr) {
  let head = null, tail = null;
  for (const v of arr) {
    const n = new Node(v);
    if (!head) head = tail = n; else { tail.next = n; tail = n; }
  }
  return head;
}

function toArray(head) {
  const out = [];
  while (head) { out.push(head.data); head = head.next; }
  return out;
}

// quick checks
let h = buildList([60,50,40,30,20,10]);
h = sortList(h);
console.log(toArray(h)); // [10,20,30,40,50,60]

h = buildList([9,2,8,5]);
h = sortList(h);
console.log(toArray(h)); // [2,5,8,9]

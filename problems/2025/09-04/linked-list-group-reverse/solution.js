function Node(key) {
  this.data = key;
  this.next = null;
}

function reverseKGroup(head, k) {
  if (!head || k <= 1) return head;

  const dummy = new Node(0);
  dummy.next = head;
  let prevTail = dummy;
  let curr = head;

  while (curr) {
    const lastNodeOfPrevPart = prevTail;
    const lastNodeOfSublist = curr;

    let prev = null;
    let i = 0;
    while (curr && i < k) {
      const nxt = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nxt;
      i++;
    }

    lastNodeOfPrevPart.next = prev;
    lastNodeOfSublist.next = curr;
    prevTail = lastNodeOfSublist;
  }

  return dummy.next;
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
let h = buildList([1,2,3,4,5,6]);
h = reverseKGroup(h, 2);
console.log(toArray(h)); // [2,1,4,3,6,5]

h = buildList([1,2,3,4,5,6]);
h = reverseKGroup(h, 4);
console.log(toArray(h)); // [4,3,2,1,6,5]


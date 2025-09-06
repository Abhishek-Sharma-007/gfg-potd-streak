function Node(d) {
  this.data = d;
  this.next = null;
}

function countNodesInLoop(head) {
  if (!head || !head.next) return 0;

  let slow = head, fast = head;
  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow === fast) {
      // count length
      let count = 1;
      let ptr = slow.next;
      while (ptr !== slow) { count++; ptr = ptr.next; }
      return count;
    }
  }
  return 0;
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

function makeLoop(head, posOneBased) {
  if (!head || posOneBased <= 0) return head;
  let loopNode = head;
  let idx = 1;
  while (loopNode && idx < posOneBased) { loopNode = loopNode.next; idx++; }
  if (!loopNode) return head;
  let tail = head;
  while (tail.next) tail = tail.next;
  tail.next = loopNode;
  return head;
}

// quick checks
let h = buildList([1, 2, 3, 4, 5]);
h = makeLoop(h, 3);
console.log(countNodesInLoop(h)); // 3

h = buildList([10, 20, 30]);
console.log(countNodesInLoop(h)); // 0

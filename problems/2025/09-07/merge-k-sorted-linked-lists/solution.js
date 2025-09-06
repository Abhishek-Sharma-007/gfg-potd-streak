function Node(d) {
  this.data = d;
  this.next = null;
}

function mergeKLists(arr) {
  // Min-heap for nodes by node.data
  const heap = [];
  const less = (a, b) => a.data < b.data;
  const swap = (i, j) => { const t = heap[i]; heap[i] = heap[j]; heap[j] = t; };
  const up = (i) => { while (i > 0) { const p = (i - 1) >> 1; if (!less(heap[i], heap[p])) break; swap(i, p); i = p; } };
  const down = (i) => { const n = heap.length; while (true) { let l = i * 2 + 1, r = l + 1, m = i; if (l < n && less(heap[l], heap[m])) m = l; if (r < n && less(heap[r], heap[m])) m = r; if (m === i) break; swap(i, m); i = m; } };
  const push = (x) => { heap.push(x); up(heap.length - 1); };
  const pop = () => { const last = heap.pop(); if (heap.length === 0) return last; const top = heap[0]; heap[0] = last; down(0); return top; };

  for (const head of arr) if (head) push(head);

  const dummy = new Node(0);
  let tail = dummy;

  while (heap.length > 0) {
    const node = pop();
    tail.next = node;
    tail = node;
    if (node.next) push(node.next);
  }

  tail.next = null;
  return dummy.next;
}

// Helpers
function buildList(a) {
  let head = null, tail = null;
  for (const v of a) {
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
let lists = [buildList([1,3,7]), buildList([2,4,8]), buildList([9])];
let h = mergeKLists(lists);
console.log(toArray(h)); // [1,2,3,4,7,8,9]

lists = [buildList([1,3]), buildList([8]), buildList([4,5,6])];
h = mergeKLists(lists);
console.log(toArray(h)); // [1,3,4,5,6,8]

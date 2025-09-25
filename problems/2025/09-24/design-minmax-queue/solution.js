class SpecialQueue {
  constructor() {
    this.q = [];
    this.minQ = [];
    this.maxQ = [];
  }
  enqueue(x) {
    this.q.push(x);
    while (this.minQ.length && this.minQ[this.minQ.length - 1] > x) this.minQ.pop();
    this.minQ.push(x);
    while (this.maxQ.length && this.maxQ[this.maxQ.length - 1] < x) this.maxQ.pop();
    this.maxQ.push(x);
  }
  dequeue() {
    const x = this.q.shift();
    if (this.minQ.length && this.minQ[0] === x) this.minQ.shift();
    if (this.maxQ.length && this.maxQ[0] === x) this.maxQ.shift();
  }
  getFront() { return this.q[0]; }
  getMin() { return this.minQ[0]; }
  getMax() { return this.maxQ[0]; }
}

const sq = new SpecialQueue();
[[1,4],[1,2],[3],[4],[2],[5]].forEach(op => {
  if (op[0] === 1) sq.enqueue(op[1]);
  else if (op[0] === 2) sq.dequeue();
  else if (op[0] === 3) console.log(sq.getFront());
  else if (op[0] === 4) console.log(sq.getMin());
  else console.log(sq.getMax());
});

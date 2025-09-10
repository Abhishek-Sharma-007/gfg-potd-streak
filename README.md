# GeeksforGeeks POTD Streak

Sharpen DSA skills with daily GeeksforGeeks POTD solutions in Python, Java, and JavaScript. Each problem folder contains:
- Problem summary with a clear approach
- Key terms & data structures in plain English
- Language notes with common syntaxes/pitfalls
- Working code in three languages

## How this repo works
- Scaffolding: use `scripts/new_potd.sh` to create `problems/<yyyy>/<mm-dd>/<slug>/` with stub files and a progress note.
- CI: Minimal workflow runs Python linters, ensures Node and Java toolchains, and compiles Java files.
- Commits: Conventional Commits; separate chore/docs from feature additions per day.
- Daily workflow: scaffold → implement (py/java/js) → add brief README + progress note → quick checks → commit.

## Runbook
- Create a new day:
```
./scripts/new_potd.sh 2025 08-28 some-problem-slug
```
- Run solutions:
  - Python: `python3 problems/<yyyy>/<mm-dd>/<slug>/solution.py`
  - Java: `javac problems/<yyyy>/<mm-dd>/<slug>/Solution.java && java -cp problems/<yyyy>/<mm-dd>/<slug> Solution`
  - JavaScript: `node problems/<yyyy>/<mm-dd>/<slug>/solution.js`

## Index (click Problem to open its README)

| Date       | Problem | Folder Path |
|------------|---------|-------------|
| 2025-09-10 | [Largest number in one swap](problems/2025/09-10/largest-number-in-one-swap/README.md) | problems/2025/09-10/largest-number-in-one-swap/ |
| 2025-09-09 | [Assign Mice Holes](problems/2025/09-09/assign-mice-holes/README.md) | problems/2025/09-09/assign-mice-holes/ |
| 2025-09-08 | [Merge Sort for Linked List](problems/2025/09-08/merge-sort-for-linked-list/README.md) | problems/2025/09-08/merge-sort-for-linked-list/ |
| 2025-09-07 | [Merge K Sorted Linked Lists](problems/2025/09-07/merge-k-sorted-linked-lists/README.md) | problems/2025/09-07/merge-k-sorted-linked-lists/ |
| 2025-09-06 | [Find length of Loop](problems/2025/09-06/find-length-of-loop/README.md) | problems/2025/09-06/find-length-of-loop/ |
| 2025-09-05 | [Segregate Even and Odd Nodes](problems/2025/09-05/segregate-even-and-odd-nodes/README.md) | problems/2025/09-05/segregate-even-and-odd-nodes/ |
| 2025-09-04 | [Linked List Group Reverse](problems/2025/09-04/linked-list-group-reverse/README.md) | problems/2025/09-04/linked-list-group-reverse/ |
| 2025-09-03 | [Reverse a Doubly Linked List](problems/2025/09-03/reverse-a-doubly-linked-list/README.md) | problems/2025/09-03/reverse-a-doubly-linked-list/ |
| 2025-09-02 | [Swap Kth nodes from ends](problems/2025/09-02/swap-kth-nodes-from-ends/README.md) | problems/2025/09-02/swap-kth-nodes-from-ends/ |
| 2025-09-01 | [Sum of Mode](problems/2025/09-01/sum-of-mode/README.md) | problems/2025/09-01/sum-of-mode/ |
| 2025-08-31 | [Container With Most Water](problems/2025/08-31/container-with-most-water/README.md) | problems/2025/08-31/container-with-most-water/ |
| 2025-08-30 | [The Celebrity Problem](problems/2025/08-30/the-celebrity-problem/README.md) | problems/2025/08-30/the-celebrity-problem/ |
| 2025-08-29 | [Smallest window containing all characters](problems/2025/08-29/smallest-window-containing-all-characters/README.md) | problems/2025/08-29/smallest-window-containing-all-characters/ |
| 2025-08-28 | [Maximize Number of 1's](problems/2025/08-28/maximize-number-of-1s/README.md) | problems/2025/08-28/maximize-number-of-1s/ |
| 2025-08-27 | [Count the number of possible triangles](problems/2025/08-27/count-possible-triangles/README.md) | problems/2025/08-27/count-possible-triangles/ |
| 2025-08-26 | [Check if a String is Subsequence of Other](problems/2025/08-26/check-if-a-string-is-subsequence-of-other/README.md) | problems/2025/08-26/check-if-a-string-is-subsequence-of-other/ |


Tip: Open any problem's README first to learn the approach, key terms, and language tips before diving into code.

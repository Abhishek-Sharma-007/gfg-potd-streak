# GeeksforGeeks POTD Streak

Daily POTD solutions in Python, Java, and JavaScript. Each entry contains a short problem note and implementations in all three languages.

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

## Index

| Date       | Problem                                   | Folder Path                                                  |
|------------|--------------------------------------------|--------------------------------------------------------------|
| 2025-08-27 | Count the number of possible triangles     | problems/2025/08-27/count-possible-triangles/                |
| 2025-08-26 | Check if a String is Subsequence of Other  | problems/2025/08-26/check-if-a-string-is-subsequence-of-other/ |

This table is appended by the scaffold script; you can tidy/reshuffle as needed.
# String stack

You have strings `pat` and `tar`. For each character in `pat` (in order), perform exactly one operation on a working string `s` (initially empty):
- Append the current character to `s`, or
- Delete the last character of `s` (no-op if `s` is empty).

After processing all characters of `pat` exactly once, decide if it is possible that `s == tar`.

## Key idea
It is possible if and only if `tar` is a subsequence of `pat`.
- Append exactly those characters of `pat` that match `tar` in order.
- For all other characters of `pat`, choose delete (which may be a no-op if `s` is empty).

## Solution
Two-pointer subsequence check scanning `pat`, advancing a pointer over `tar` when characters match.

Time: O(|pat|), Space: O(1).

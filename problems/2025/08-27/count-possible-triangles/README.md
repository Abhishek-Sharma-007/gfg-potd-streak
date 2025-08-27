# Count the number of possible triangles
Given arr[], count how many triplets (i<j<k) form valid triangles. Triangle condition: a+b>c for sides in sorted order.

Approach: Sort; fix k as largest; two-pointer (i=0, j=k-1). If arr[i]+arr[j]>arr[k], add (j-i) and j-- else i++. O(n^2).



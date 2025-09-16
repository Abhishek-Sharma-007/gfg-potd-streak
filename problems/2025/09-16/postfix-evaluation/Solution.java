import java.util.*;
public class Solution {
    public int evaluatePostfix(String[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String tok : arr) {
            switch (tok) {
                case "+": {
                    int b = st.pop(), a = st.pop();
                    st.push(a + b);
                    break;
                }
                case "-": {
                    int b = st.pop(), a = st.pop();
                    st.push(a - b);
                    break;
                }
                case "*": {
                    int b = st.pop(), a = st.pop();
                    st.push(a * b);
                    break;
                }
                case "/": {
                    int b = st.pop(), a = st.pop();
                    // floor division toward -infinity
                    int q = (int)Math.floor((double)a / (double)b);
                    st.push(q);
                    break;
                }
                case "^": {
                    int b = st.pop(), a = st.pop();
                    st.push((int)Math.pow(a, b));
                    break;
                }
                default:
                    st.push(Integer.parseInt(tok));
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evaluatePostfix(new String[]{"2","3","1","*","+","9","-"})); // -4
        System.out.println(s.evaluatePostfix(new String[]{"2","3","^","1","+"})); // 9
    }
}

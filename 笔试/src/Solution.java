import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        minStack minStack = new minStack();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            if ("push".equals(s[0])) {
                minStack.push(Integer.parseInt(s[1]));
            } else if ("getMin".equals(s[0])) {
                System.out.println(minStack.getMin());
            } else if ("pop".equals(s[0])) {
                minStack.pop();
            } else if ("top".equals(s[0])) {
                System.out.println(minStack.top());
            }
        }
    }

    static class minStack {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> minstack = new ArrayList<>();

        public void push(int x) {
            stack.add(x);
            if (minstack.isEmpty() || minstack.get(minstack.size() - 1) > x) {
                minstack.add(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int p = stack.get(stack.size() - 1);
                if (p == minstack.get(minstack.size() - 1)) minstack.remove(minstack.size() - 1);
                stack.remove(stack.size() - 1);
            }
        }

        public int top() {
            return stack.isEmpty() ? 0 : stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minstack.isEmpty() ? 0 : minstack.get(minstack.size() - 1);
        }
    }
}

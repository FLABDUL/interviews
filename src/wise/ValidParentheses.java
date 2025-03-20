package wise;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println("result: " + validParentheses.isValidStack(s));
    }

    public boolean isValidStack(String s) {
        //stack chars
        //for each char in string array
        //if char ( push opposite, same for {, and [
        //if stack empty or not c return false

        //return empty stack or not
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {//stack pop occurs if not empty in real-time
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidHashMap(String s) {
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');

        Stack<Character> stack = new Stack<>();
        System.out.println("Processing string: " + s);

        for (char c : s.toCharArray()) {
            System.out.println("Current character: " + c);

            if (bracketMap.containsKey(c)) {
                stack.push(bracketMap.get(c));
                System.out.println("Pushing expected: " + bracketMap.get(c));
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty, invalid sequence");
                    return false;
                }
                char popped = stack.pop();
                System.out.println("Popped from stack: " + popped);
                if (popped != c) {
                    System.out.println("Mismatch found: expected " + popped + " but found " + c);
                    return false;
                }
            }
        }

        boolean isValid = stack.isEmpty();
        System.out.println("Stack empty: " + isValid);
        return isValid;
    }
}
/**
 * Checks if the given string has valid parentheses.
 * Uses a Stack to store expected closing brackets and verifies them.
 *
 * Time Complexity: O(n) - We iterate through the string once.
 * Space Complexity: O(n) - In the worst case, we store all opening brackets in the stack.
 *
 * Pros:
 * - Simple and easy-to-understand approach.
 * - Efficient for checking balanced parentheses.
 *
 * Cons:
 * - Uses extra space due to the stack.
 * - Only works for simple cases with well-defined opening and closing pairs.
 *
 * Algorithm used: Stack-based approach (LIFO - Last In, First Out)
 */

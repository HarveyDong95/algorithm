import java.util.Stack;

// import com.sun.tools.classfile.StackMapTable_attribute.stack_map_frame;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.11%)
 * Total Accepted:    543.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> sta= new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                sta.push(')');
            else if (c == '[')
                sta.push(']');
            else if (c == '{')
                sta.push('}');
            else {  //when c == } ] )
                if (sta.isEmpty() || sta.pop() != c) {
                    return false;
                }
            }
        }
        return sta.isEmpty();
    } 
}



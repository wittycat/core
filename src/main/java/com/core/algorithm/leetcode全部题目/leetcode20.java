package com.core.algorithm.leetcode全部题目;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by chenxun.
 * Date: 2020/6/6 下午7:00
 * Description:
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public  class leetcode20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        {
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.empty()) {
                Character character = stack.peek();
                Character character1 = map.get(character);
                if (character1 == chars[i]) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
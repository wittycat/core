package com.core.algorithm.nowcoder.面试必刷TOP101.d四堆栈队列;

import java.util.Stack;

/**
 * Created by chenxun.
 * Date: 2022/6/5 4:47 PM
 * Description:
 */
public class BM49表达式求值 {
    static Stack<Integer> nums = new Stack();
    static Stack<Character> ops = new Stack();
    public static int solve(String s) {
        String str = s.replace("", "");
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            if (isNum(c)) {
                String numbers = "";
                while (isNum(c)) {
                    numbers = numbers + c;
                    i++;
                    if (i >= chars.length) {
                        break;
                    }
                    c = chars[i];
                }
                nums.push(Integer.valueOf(numbers));
            } else {
                //直接入栈
                if (c == '+' || c == '-' || c == '(') {
                    ops.push(c);
                }
                if (c == '*') {
                    //a*b 乘以数值直接计算
                    if ((i + 1) < chars.length && chars[i + 1] != '(') {
                        Integer a = nums.pop();
                        Character opsStr = c;

                        i++;
                        c = chars[i];

                        String numbers = "";
                        while (isNum(c)) {
                            numbers = numbers + c;
                            i++;
                            if (i >= chars.length) {
                                break;
                            }
                            c = chars[i];
                        }
                        Integer b = Integer.valueOf(numbers);

                        cal(nums, a, b, opsStr);
                        continue;
                    } else {
                        //a*（b+c) 乘以括号直接 入栈
                        ops.push(c);
                    }
                }

                //结束括号 直接计算
                if (c == ')') {
                    Character pop = ops.peek();
                    while (pop != '(') {
                        Integer b = nums.pop();
                        Character cc = ops.pop();
                        Integer a = nums.pop();
                        cal(nums, a, b, cc);
                        //继续计算括号里的表达式
                        pop = ops.peek();
                    }
                    //移除 （ 符号
                    ops.pop();

                    //6*(a+b)
                    if (!ops.empty() && ops.peek() == '*') {
                        Integer b = nums.pop();
                        Character cc = ops.pop();
                        Integer a = nums.pop();
                        cal(nums, a, b, cc);
                    }
                }
                i++;
            }
        }
        //从后计算 优化 可以使用队列 就不需要处理 -2-3 特殊情况：102行
        while (!ops.empty()) {
            Integer b = nums.pop();
            Integer a = nums.pop();
            cal(nums, a, b, ops.pop());
        }
        return nums.pop();
    }

    static void cal(Stack<Integer> nums, int a, int b, Character opsStr) {
        if (opsStr == '+') {
            nums.push(a + b);
        }
        if (opsStr == '-') {
            if (!ops.empty() && ops.peek() == '-') {
                //1-2-3      由于从后计算所以需要转化，
                ops.pop();
                ops.push('+');
                nums.push(-a-b);
            }else {
                nums.push(a-b);
            }
        }
        if (opsStr == '*') {
            nums.push(a * b);
        }
    }

    static boolean isNum(char c) {
        int n = (int) c;
        if (n >= 48 && n <= 57) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(solve("(3+4)*(5+(2-3))"));
    }
}
package com.core.algorithm.nowcoder面试必刷TOP101.d四堆栈队列;

import java.util.Stack;

/**
 * Created by chenxun.
 * Date: 2022/5/11 5:37 PM
 * Description:
 */
public class BM42用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
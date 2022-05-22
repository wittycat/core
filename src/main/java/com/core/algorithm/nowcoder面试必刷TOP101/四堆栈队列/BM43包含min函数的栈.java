package com.core.algorithm.nowcoder面试必刷TOP101.四堆栈队列;

import java.util.Stack;

/**
 * Created by chenxun.
 * Date: 2022/5/11 6:05 PM
 * Description:
 */
public class BM43包含min函数的栈 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        if(stack2.empty()||node<stack2.peek()){
            stack2.push(node);
        }else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
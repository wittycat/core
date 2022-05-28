package com.core.algorithm.nowcoder面试必刷TOP101.d四堆栈队列;

import java.util.Stack;

/**
 * Created by chenxun.
 * Date: 2022/5/13 4:08 PM
 * Description:
 */
public class BM44有效括号序列 {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        if(s==null||s.equals("")){
            return false;
        }
        char[] chars = s.toCharArray();
        if(chars.length<2){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
                stack.push(chars[i]);
                continue;
            }else {
                if(stack.empty()){
                    return false;
                }
                if(chars[i]==')'){
                   if( stack.pop()!='('){
                       return false;
                   }
                }
                if(chars[i]==']'){
                    if( stack.pop()!='['){
                        return false;
                    }
                }
                if(chars[i]=='}'){
                    if(stack.pop()!='{'){
                        return false;
                    }
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
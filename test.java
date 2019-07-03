package cn.chci.yncccy.jucaiyun.z_data_struct;

import cn.chci.yncccy.jucaiyun.z_data_struct.stack.ArrayStack;

// import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            // 遍历字符串
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '('){
                // 如果遇到左左边的括号 插入栈中
                stack.push(c);
            } else {
                // 如果遇到右边的括号，则取出栈顶的元素ui之匹配
                if (stack.isEmpty()){
                    return false;
                }
                // 取出栈顶元素
                char topChar = stack.pop();
                if (c == ')' && topChar != '('){
                    return false;
                }

                if (c == ']' && topChar != '['){
                    return false;
                }

                if (c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
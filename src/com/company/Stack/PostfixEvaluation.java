package com.company.Stack;

import java.util.Stack;

public class PostfixEvaluation {
   static int postfixEvaluation(String exp){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(c == ' ')
                continue;
            else if(Character.isDigit(c)){
                int n = 0;
                while(Character.isDigit(c)){
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                --i;
                stack.push(n);
            }
//                stack.push(c-'0');
            else{
                int a = stack.pop();
                int b = stack.pop();
                switch (c){
                    case '+':
                        stack.push(a+b);
                        break;
                    case '-':
                        stack.push(b-a);
                        break;
                    case '/':
                        stack.push(b/a);
                        break;
                    case '*':
                        stack.push(b*a);
                        break;
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println("postfix evaluation: "+postfixEvaluation(exp));
    }
}

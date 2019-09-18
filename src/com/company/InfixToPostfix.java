package com.company;

import java.util.Stack;

public class InfixToPostfix {
    static int Priority(char ch)
    {
       switch (ch)
       {
           case '+':
           case'-':
               return 1;
           case '*':
           case'/':
               return 2;
           case '^':
               return 3;
       }
       return -1;
    }
    static String evaluate(String exp){
        String result ="";
        Stack <Character> s = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
             result+=ch;
            }
            else if(ch=='(')
                s.push(ch);
            else if(ch==')')
            {
                while(!s.empty() && s.peek()!='(')
                   result+= s.pop();
                if(!s.empty() && s.peek() !='(')
                    return "Invalid expression";
                else
                    s.pop();
            }
            else{
                while(!s.empty() && Priority(ch)<=Priority(s.peek())){
                    if(s.peek()=='(')
                       return "Invalid";
                    result += s.pop();
                }
                s.push(ch);
            }
        }
        while(!s.empty()){
            if(s.peek()=='(')
               return "Invalid exp";
            result +=s.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(evaluate(exp));
    }
}

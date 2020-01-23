package com.company.Stack;

import java.util.Stack;

public class InfixToPostfix {
  static   int predecence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
          return -1;
    }

    static String infixToPostfix(String str){
        Stack<Character> s = new Stack<>();
        String res = "";
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c))
                res += c;
            else if(c == '(')
                s.push(c);
            else if(c == ')'){
                while(!s.empty() && s.peek()!='(')
                    res += s.pop();
                if(!s.empty() && s.peek()!='(')
                    return "invalid expression";
                else
                    s.pop();
            }
            else{
                while(!s.empty() && predecence(c)<= predecence(s.peek()))
                    res += s.pop();
                s.push(c);
            }
        }
        while(!s.empty())
            res += s.pop();

        return res;
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(infixToPostfix(exp));
    }
}

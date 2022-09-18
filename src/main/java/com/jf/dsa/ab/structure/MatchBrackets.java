package com.jf.dsa.ab.structure;

import java.util.ArrayDeque;
import java.util.Deque;

public class MatchBrackets {

    private Deque<Character> stack = new ArrayDeque<Character>();
    String brackets = "({[]})";

    public boolean isBracketsMatching(String data){
        if (data == null || data == "") {
            return true;
        }


        for (char c : data.toCharArray()){

            if(!brackets.contains(String.valueOf(c))){
                continue;
            }

            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            char bChar;
            switch (c){
                case ')':
                    bChar = stack.pop();
                    if(bChar == '{' || bChar == '[')
                        return false;
                    break;
                case '}':
                    bChar = stack.pop();
                    if(bChar == '[' || bChar == '(')
                        return false;
                    break;
                case ']':
                    bChar = stack.pop();
                    if(bChar == '(' || bChar == '{')
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String data = "[cec(cece(cecec)ceec)cece}ce]";
        MatchBrackets mb = new MatchBrackets();
        if(mb.isBracketsMatching(data)){
            System.out.println("brackets matched");
        }else{
            System.out.println("brackets not matched");
        }

    }


}

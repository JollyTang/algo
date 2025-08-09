package hot100;

import java.util.*;

// 输入：s = "3[a2[c]]"
// 输出："accaccacc"

public class Leetcode394 {
    public String decodeString(String s) {
        System.out.println(s);
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.charAt(i) + "";
            System.out.println(i + " " + temp);
            if (!temp.equals("]")) {
                stack.push(temp);
                System.out.println("push " + temp);
                continue;
            }
            String tempstring = "";
            while (true) {
                String num = "";
                String pop = stack.pop();
                if (!pop.equals("[")) {
                    tempstring = pop + tempstring;
                } else {
                    num = stack.pop();
                    System.out.println("nums: " + num + " tempstring = " + tempstring);
                    String newressulString = getString(num, tempstring);
                    System.out.println(newressulString);
                    stack.push(newressulString);
                    break;
                }
            }
        }
        return stack.pop();
    }

    public String getString(String num, String s) {
        int num1 = Integer.parseInt(num);
        String res = "";
        for (int i = 0; i < num1; i++) {
            res += s;
        }
        return res;
    }
}

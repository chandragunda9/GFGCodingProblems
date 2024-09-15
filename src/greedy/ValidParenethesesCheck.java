package greedy;

import java.util.Stack;

public class ValidParenethesesCheck {
    static boolean ispar(String x) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.add(ch);
            } else {
                if (st.isEmpty())
                    return false;
                switch (ch) {
                    case '}': {
                        char top = st.pop();
                        if (top == '(' || top == '[')
                            return false;
                        break;
                    }
                    case ']': {
                        char top = st.pop();
                        if (top == '(' || top == '{')
                            return false;
                        break;
                    }
                    case ')': {
                        char top = st.pop();
                        if (top == '{' || top == '[')
                            return false;
                        break;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}

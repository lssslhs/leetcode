import java.util.*;

public class ValidParen{
  public static void main(String[] args) {
    System.out.println(isValid("(([]))"));
  }

  public static boolean isValid(String s) {
    if(s==null) {
      return false;
    }

    Stack<Character> stack = new Stack<Character>();

    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      if(c=='(' || c=='{' || c=='[') {
        stack.push(c);
      }
      if(c==')') {
        if(stack.empty()) {
          return false;
        }
        char c1 = stack.pop();
        if(c1 != '(') {
          return false;
        }
      }
      if(c=='}') {
        if(stack.empty()) {
          return false;
        }
        char c1 = stack.pop();
        if(c1 != '{') {
          return false;
        }
      }
      if(c==']') {
        if(stack.empty()) {
          return false;
        }
        char c1 = stack.pop();
        if(c1 != '[') {
          return false;
        }
      }
    }

    if(!stack.empty()) {
      return false;
    }
    else {
      return true;
    }
  }
}

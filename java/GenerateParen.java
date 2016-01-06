import java.util.*;

public class GenerateParen {
  public static void main(String[] args) {
    System.out.println(generateParenthesis(2));
  }

  public static List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    if(n<=0) {
      return result;
    }
    helper(result, 0, 0, "", n);

    return result;
  }

  public static void helper(List<String> res, int left, int right, String s, int n) {
    if(right==n) {
      res.add(s);
      return;
    }
    if(left<n) {
      helper(res, left+1, right, s+'(', n);
    }
    if(right<left) {
      helper(res, left, right+1, s+')', n);
    }

  }
}

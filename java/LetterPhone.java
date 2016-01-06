import java.util.*;

public class LetterPhone {
  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }

  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<String>();
    if(digits == null || digits.length()==0) {
      return result;
    }

    Hashtable<Character, String> table = new Hashtable<Character, String>();
    table.put('1', "");
    table.put('2', "abc");
    table.put('3', "def");
    table.put('4', "ghi");
    table.put('5', "jkl");
    table.put('6', "mno");
    table.put('7', "pqrs");
    table.put('8', "tuv");
    table.put('9', "wxyz");
    table.put('0', "");
    table.put('#', "");
    table.put('*', "");
    StringBuilder sb = new StringBuilder();
    helper(result, sb, table, 0, digits);

    return result;
  }

  public static void helper(List<String> result, StringBuilder sb, Hashtable<Character, String> table, int index, String digits) {
    if(index == digits.length()) {
      result.add(sb.toString());
      return;
    }
    String s = table.get(digits.charAt(index));
    for(int i=0; i<s.length(); i++) {
      sb.append(s.charAt(i));
      helper(result, sb, table, index+1, digits);
      sb.deleteCharAt(sb.length()-1);
    }
  }
}

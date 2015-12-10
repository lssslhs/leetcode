public class LongestPaliSub {
  public static void main(String[] args) {
    System.out.println(longestPalindrome("acddsacddca"));
    System.out.println(longestPalindrome("aaaa"));
    System.out.println(longestPalindrome("dvdf"));
  }

  public static String longestPalindrome(String s) {
    if(s.length()==0) {
      return null;
    }
    if(s.length()==1) {
      return s;
    }

    String longestPali = "";
    String temp = "";

    for(int i=0; i<s.length()-1; i++) {
      temp =  findPali(s, i, i);
      if(temp.length() > longestPali.length()) {
        longestPali = temp;
      }
      temp = findPali(s, i, i+1);
      if(temp.length() > longestPali.length()) {
        longestPali = temp;
      }
    }

    return longestPali;
  }

  public static String findPali(String s, int start, int end) {
    while(start>=0 && end < s.length() && s.charAt(start)==s.charAt(end)) {
      start--;
      end++;
    }

    return s.substring(start+1, end);
  }

}

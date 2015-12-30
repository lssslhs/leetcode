public class RegularExpressionMatch {
  public static void main(String[] args) {
    System.out.println(isMatch("aa","a"));
    System.out.println(isMatch("aa","aa"));
    System.out.println(isMatch("aaa","aa"));
    System.out.println(isMatch("aa","a*"));
    System.out.println(isMatch("ab",".*"));
    System.out.println(isMatch("aab","c*a*b*"));
  }

  public static boolean isMatch(String s, String p) {
    return match(s, 0, p, 0);
  }

  public static boolean match(String s, int p1, String p, int p2) {
    //end of p
    if(p2 == p.length()) {
      return p1 == s.length();
    }

    //check p2+1 is star or not
    if(p2 == p.length()-1 || p.charAt(p2+1)!='*') {
      if(p1==s.length() || s.charAt(p1)!=p.charAt(p2) && p.charAt(p2)!='.') {
        return false;
      }
      else {
        return match(s, p1+1, p, p2+1);
      }
    }

    //p.charAt(p2+1) == '*'
    while(p1<s.length() && (p.charAt(p2)=='.' || s.charAt(p1) == p.charAt(p2))) {
      if(match(s, p1, p, p2+2)) {
        return true;
      }
      p1++;
    }

    return match(s, p1, p, p2+2);
  }
}

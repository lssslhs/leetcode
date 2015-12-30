public class PalindromeNumber {

  public static void main(String[] args) {
    System.out.println(isPalindrome(1234321));
    System.out.println(isPalindrome(-123));
  }

  public static boolean isPalindrome(int x) {
    if(x<0) {
      return false;
    }

    long tempX = x
    ,    tempY = 0;

    while(tempX>0) {
      long mod = tempX % 10;
      tempY = tempY * 10 + mod;
      tempX /= 10;
    }
    if(tempY == x) {
      return true;
    }
    else {
      return false;
    }
  }
}

public class ReverseInteger {

  public static void main(String[] args) {
    System.out.println(reverse(123));
    System.out.println(reverse(-321));
  }

  public static int reverse(int x) {
    if(x==Integer.MIN_VALUE) {
      return 0;
    }

    boolean neg = x < 0?true:false;
    int result = 0;

    if(neg){
      x = x * -1;
    }

    int max = Integer.MAX_VALUE;

    while(x>0) {
      int add = x % 10;
      if(result > max/10 || result * 10 > max - add){
        return 0;
      }
      result *= 10;
      result += add;
      x /= 10;
    }

    if(neg) {
      return -1 * result;
    }
    else {
      return result;
    }
  }
}

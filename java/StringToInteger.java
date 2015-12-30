public class StringToInteger {
  public static void main(String[] args) {
    System.out.println(myAtoi("-2147483649"));
  }

  public static int myAtoi(String str) {
    if(str.length()==0) {
      return 0;
    }

    boolean neg = false;
    int index = 0;
    int result = 0;

    while(index<str.length() && str.charAt(index)==' ') {
      index++;
    }

    if(index==str.length()) {
      return 0;
    }

    if(str.charAt(index)=='-') {
      neg = true;
      index++;
    }
    else if(str.charAt(index)=='+') {
      index++;
    }

    while(index<str.length() && str.charAt(index)=='0') {
      index++;
    }

    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;

    for(;index<str.length();index++) {
      if(str.charAt(index)<'0' || str.charAt(index)>'9') {
        return neg? -1*result : result;
      }
      int add = (str.charAt(index) - '0');
      if(neg) {
        int negResult = -1*result;
        if(negResult<min/10 || negResult*10 < min + add) {
          return min;
        }
      }
      else {
        if(result>max/10 || result*10 > max - add) {
          return max;
        }
      }
      result = result*10 + add;
    }

    return neg? -1*result : result;
  }
}

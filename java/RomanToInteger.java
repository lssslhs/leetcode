import java.util.Hashtable;

public class RomanToInteger {

  public static void main(String[] args) {
    System.out.println(romanToInt("DCXXI"));
  }

  public static int romanToInt(String s) {
    if(s==null || s.length()==0) {
      return 0;
    }

    int pre = Integer.MAX_VALUE
    ,   cur = 0
    ,   result = 0
    ,   value = 0;

    char[] arr = s.toCharArray();

    Hashtable<Character, Integer> roman = new Hashtable<Character, Integer>();
    roman.put('I', 1);
    roman.put('V', 5);
    roman.put('X', 10);
    roman.put('L', 50);
    roman.put('C', 100);
    roman.put('D', 500);
    roman.put('M', 1000);

    for(int i=0; i<arr.length; i++) {
      cur = roman.get(arr[i]);
      if(cur>pre) {
        value = cur - 2*pre;
      }
      else {
        value = cur;
      }
      pre = cur;
      result += value;
    }

    return result;
  }
}

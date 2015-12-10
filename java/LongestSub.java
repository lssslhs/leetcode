import java.util.Hashtable;

public class LongestSub{
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("dvdf"));
  }

  public static int lengthOfLongestSubstring(String s) {
    if(s==null || s.length()==0) {
      return 0;
    }

    Hashtable<Character, Integer> t = new Hashtable<Character, Integer>();
    int anchor = 0
    ,   maxLength = 0
    ,   curLength = 0;
    char[] arr = s.toCharArray();

    for(int i=0; i<arr.length; i++) {
      if(!t.containsKey(arr[i])) {
        t.put(arr[i], i);
        curLength++;
      }
      else {
        int pos = t.get(arr[i]);
        t.put(arr[i], i);
        if(pos<anchor) {
          curLength++;
        }
        else {
          if(curLength>maxLength) {
            maxLength = curLength;
          }
          anchor = pos + 1;
          curLength = i - anchor + 1;
        }
      }
    }

    return maxLength > curLength? maxLength: curLength;
  }
}

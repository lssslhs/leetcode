public class ZigZag {
  public static void main(String[] args) {
    System.out.println(convert("ABCD", 3));
  }

  public static String convert(String s, int numRows) {
    if(numRows<=1) {
      return s;
    }

    int diff = 2 * (numRows-1);
    int sub = 0;

    StringBuilder sb = new StringBuilder();

    for(int i=0; i<numRows; i++) {
      int index = i;
      int flag = 0;
      while(index < s.length()) {
        sb.append(s.charAt(index));
        if(sub==diff || sub==0) {
          index+=diff;
        }
        else {
          if(flag%2==0) {
            index+=diff-sub;
          }
          else {
            index+=sub;
          }
          flag++;
        }
      }
      sub+=2;
    }

    return sb.toString();
  }
}

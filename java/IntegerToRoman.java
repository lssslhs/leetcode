public class IntegerToRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(1050));
    System.out.println(intToRoman(3999));
  }

  public static String intToRoman(int num) {
    if(num==0) {
      return "";
    }

    int base = 1000
    ,   index = 0;
    String[] one = new String[] {"M", "C", "X", "I"};
    String[] five = new String[] {"none", "D", "L", "V"};
    StringBuilder sb = new StringBuilder();

    while(base>0) {
      int value = num/base;
      num -= value * base;
      base = base/10;
      if(value==0) {
        index++;
        continue;
      }
      else if(value<4) {
        for(int i=0; i<value; i++){
          sb.append(one[index]);
        }
      }
      else if(value==4) {
        sb.append(one[index]);
        sb.append(five[index]);
      }
      else if(value==5){
        sb.append(five[index]);
      }
      else if(value<9) {
        sb.append(five[index]);
        for(int i=0; i<value-5; i++) {
          sb.append(one[index]);
        }
      }
      else {
        sb.append(one[index]);
        sb.append(one[index-1]);
      }
      index++;
    }

    return sb.toString();
  }
}

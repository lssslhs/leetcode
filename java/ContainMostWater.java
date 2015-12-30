public class ContainMostWater {
  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1,1,2}));
  }

  public static int maxArea(int[] height) {

    int maxArea = 0
    ,   curArea = 0
    ,   h = 0
    ,   w = 0
    ,   p1 = 0
    ,   p2 = height.length - 1;

    while(p1<p2) {
      w = p2 - p1;
      if(height[p1]>height[p2]) {
        h = height[p2];
        p2--;
      }
      else {
        h = height[p1];
        p1++;
      }
      curArea = h * w;
      if(curArea > maxArea) {
        maxArea = curArea;
      }
    }

    return maxArea;
  }
}

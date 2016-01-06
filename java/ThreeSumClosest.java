import java.util.*;

public class ThreeSumClosest {
  public static void main(String[] args) {
    System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, 100));
  }

  public static int threeSumClosest(int[] nums, int target) {
    if(nums==null || nums.length<=2) {
      return 0;
    }

    Arrays.sort(nums);

    int i = 0
    ,   j = 0
    ,   k = 0
    ,   last = nums.length-1
    ,   sum = 0
    ,   diff = 0
    ,   curMin = Integer.MAX_VALUE
    ,   result = 0;

    while(i<last) {
      j = i + 1;
      k = last ;
      while(j<k) {
        sum = nums[i] + nums[j] + nums[k];
        diff = Math.abs(sum - target);
        if(diff < curMin) {
          curMin = diff;
          result = sum;
        }
        if(sum > target) {
          k--;
        }
        else if(sum < target) {
          j++;
        }
        else {
          return target;
        }
      }
      i++;
    }

    return result;
  }
}

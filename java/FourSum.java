import java.util.*;

public class FourSum {
  public static void main(String[] args) {
    System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums==null || nums.length<4) {
      return result;
    }
    Arrays.sort(nums);
    int len = nums.length - 3;
    for(int i=0; i<len; i++) {
      threeSum(result, nums, i, target-nums[i]);
    }

    return result;
  }

  public static void threeSum(List<List<Integer>> result, int[] nums, int start, int target) {
    int i = start + 1
    ,   j = 0
    ,   k = 0
    ,   sum = 0
    ,   a = 0
    ,   b = 0
    ,   c = 0
    ,   last = nums.length-1;

    while(i<last) {
      a = nums[i];
      j = i + 1;
      k = last;
      while(j<k) {
        b = nums[j];
        c = nums[k];
        sum = a + b + c;
        if(sum==target) {
          List<Integer> set = new ArrayList<Integer>();
          set.add(nums[start]);
          set.add(nums[i]);
          set.add(nums[j]);
          set.add(nums[k]);
          result.add(set);
        }
        if(sum<=target) {
          while(j<k && nums[j]==b) {
            j++;
          }
        }
        if(sum>=target) {
          while(j<k && nums[k]==c) {
            k--;
          }
        }
      }
      while(i<last && nums[i]==a) {
        i++;
      }
    }
  }
}

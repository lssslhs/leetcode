import java.util.*;

public class ThreeSum {
  public static void main(String[] args) {
    System.out.println(threeSum_2(new int[]{6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5}));
    //System.out.println(threeSum(new int[]{6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5}));
  }

  //n^2
  public static List<List<Integer>> threeSum_2(int[] nums){
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if(nums==null || nums.length<3) {
      return result;
    }
    Arrays.sort(nums);

    int i = 0
    ,   j = 0
    ,   k = 0
    ,   a = 0
    ,   b = 0
    ,   c = 0
    ,   last = nums.length-1
    ,   sum = 0;

    while(i<last) {
      a = nums[i];
      j = i+1;
      k = last;
      while(j<k) {
        b = nums[j];
        c = nums[k];
        sum = a + b + c;
        if(sum==0) {
          List<Integer> set = new ArrayList<Integer>();
          set.add(a);
          set.add(b);
          set.add(c);
          result.add(set);
        }
        if(sum<=0) {
          while(j<k && nums[j]==b) j++;
        }
        if(sum>=0) {
          while(j<k && nums[k]==c) k--;
        }
      }
      while(i<last && nums[i]==a) i++;
    }

    return result;
  }

  //n^3
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if(nums==null || nums.length==0) {
      return result;
    }
    Arrays.sort(nums);
    List<Integer> comb = new ArrayList<Integer>();
    helper(result, comb, nums, 0, 0);

    return result;
  }

  public static void helper(List<List<Integer>> res, List<Integer> comb, int[] nums, int n, int index){
    if(comb.size()==3 && n==0) {
      res.add(new ArrayList<Integer>(comb));
      return;
    }

    for(int i=index; i<nums.length; i++) {
      comb.add(nums[i]);
      helper(res, comb, nums, n+nums[i], i+1);
      comb.remove(comb.size()-1);
    }
  }
}

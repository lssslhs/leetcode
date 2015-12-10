import java.util.Hashtable;

public class TwoSum {

  public static void main(String[] args) {
    int[] test = {2,3,4} ;
    int[] ans = twoSum(test, 6);
    for(int i=0; i<ans.length; i++) {
      System.out.println(ans[i]);
    }
  }

  public static int[] twoSum(int[] nums, int target) {
    if(nums.length == 0) {
      return null;
    }
    Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
    int[] result = new int[2];
    for(int i=0; i<nums.length; i++) {
      if(table.containsKey(nums[i])) {
        result[0] = table.get(nums[i]) + 1;
        result[1] = i + 1;
        return result;
      }
      else {
        table.put(target-nums[i], i);
      }
    }
    return null;
  }
}

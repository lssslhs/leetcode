/**
* @param {number[]} nums
* @param {number} target
* @return {number}
*/
var threeSumClosest = function(nums, target) {
  if(nums.constructor !== Array && nums.length<3) {
    return null;
  }

  nums.sort(function(a,b){return a - b});

  var i = 0
  ,   j = 0
  ,   k = 0
  ,   last = nums.length - 1
  ,   sum = 0
  ,   diff = 0
  ,   result = 0
  ,   min = Number.MAX_VALUE;

  while(i < last) {
    j = i + 1;
    k = last;
    while(j < k) {
      sum = nums[i] + nums[j] + nums[k];
      diff = Math.abs(sum - target);
      if(diff<min) {
        min = diff;
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
};

console.log(threeSumClosest([1, 1, 1, 0], 100));

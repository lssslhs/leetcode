/**
* @param {number[]} nums
* @return {number[][]}
*/
var threeSum = function(nums) {
  if(nums.constructor !== Array && nums.length<3) {
    return null;
  }

  nums.sort(function(a,b){return a-b});

  var i = 0
  ,   j = 0
  ,   k = 0
  ,   a = 0
  ,   b = 0
  ,   c = 0
  ,   sum = 0
  ,   last = nums.length - 1;

  var result = [];

  while(i<last) {
    a = nums[i];
    j = i + 1;
    k = last;
    while(j<k) {
      b = nums[j];
      c = nums[k];
      sum = a + b + c;
      if(sum==0) {
        result.push([a,b,c]);
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
};

console.log(threeSum([-1, 0, 1, 2, -1, -4]));

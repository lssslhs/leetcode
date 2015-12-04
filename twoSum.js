var twoSum = function(nums, target) {

  if(nums.length===0) {
    return ;
  }

  var table = {};
  for(var i=0; i<nums.length; i++) {
    var diff = target - nums[i];
    if(table[nums[i]]!==undefined) {
      return [table[nums[i]], i+1];
    }
    else {
      table[diff] = (i+1);
    }
  }
};

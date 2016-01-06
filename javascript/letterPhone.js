/**
* @param {string} digits
* @return {string[]}
*/
var letterCombinations = function(digits) {
  if(digits.length==0) {
    return [];
  }

  var map = {
    '0': "",
    '1': "",
    '2': "abc",
    '3': "def",
    '4': "ghi",
    '5': "jkl",
    '6': "mno",
    '7': "pqrs",
    '8': "tuv",
    '9': "wxyz",
  };

  var comb = []
  ,   result = [];

  helper(result, comb, map, 0, digits);

  return result;
};

var helper = function(result, comb, map, index, digits) {
  if(index == digits.length) {
    result.push(comb.join(""));
    return;
  }
  var s = map[digits[index]];
  for(var i=0; i<s.length; i++) {
    comb.push(s[i]);
    helper(result, comb, map, index+1, digits);
    comb.pop();
  }
}

console.log(letterCombinations("23"));

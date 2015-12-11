/**
* @param {string} s
* @param {number} numRows
* @return {string}
*/
var convert = function(s, numRows) {
  if(numRows<=1) {
    return s;
  }

  var diff = (numRows-1) * 2
  ,   sub = 0
  ,   result = "";

  for(var i=0; i<numRows; i++) {
    var index = i
    ,   flag = 0;
    while(index<s.length) {
      result+=s[index];
      if(sub===0 || sub===diff) {
        index+=diff;
      }
      else {
        if(flag%2===0) {
          index+=diff-sub;
        }
        else {
          index+=sub;
        }
        flag++;
      }
    }
    sub+=2;
  }

  return result;
};

console.log(convert("ABCD",3));

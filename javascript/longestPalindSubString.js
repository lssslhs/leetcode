/**
* @param {string} s
* @return {string}
*/
var longestPalindrome = function(s) {

  var isPalindrome = true;
  var len = Math.floor(s.length/2);
  for(var i =0; i < len ; i++) {
    if(s[i] !== s[s.length-i-1]) {
      isPalindrome = false;
      break;
    }
  }

  if(isPalindrome) return s;

  s = [].join.call(s,"#");
  s = "$#" + s + "#$";
  var p = []
  ,   center = 1
  ,   right = 1
  ,   i_mirror = 0
  ,   max = 0
  ,   maxIndex = 0;

  for(var i=1; i<s.length-1; i++) {
    i_mirror = 2 * center - i ;
    p[i] = right > i? Math.min(right-i, p[i_mirror]): 1;

    while(s[i-p[i]]===s[i+p[i]]) p[i]++;

    if(i+p[i]>right) {
      right = i + p[i];
      center = i;
    }

    if(p[i] > max) {
      max = p[i];
      maxIndex = i;
    }
  }
  return s.substr(maxIndex - max+1, max*2 -1).replace(/[#$]/g,"");
};

var lengthOfLongestSubstring = function(s) {
  var maxLen = 0
  ,   curLen = 0
  ,   anchor = 0
  ,   charTable = {};

  for(var i=0; i<s.length; i++) {
    if(charTable[s[i]]===undefined || charTable[s[i]]<anchor) {
      curLen ++;
    }
    else {
      if(curLen>maxLen) {
        maxLen = curLen;
      }
      anchor = charTable[s[i]] + 1;
      curLen = i - anchor + 1;
    }
    charTable[s[i]] = i;
  }
  return curLen>maxLen?curLen:maxLen;
};

console.log(lengthOfLongestSubstring("aa"));
console.log(lengthOfLongestSubstring("dvdf"));

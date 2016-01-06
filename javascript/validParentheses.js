/**
* @param {string} s
* @return {boolean}
*/
var isValid = function(s) {
  if(typeof(s)!=="string") {
    return false;
  }
  var stack = [];

  for(var i=0; i<s.length; i++) {
    var c = s.charAt(i);
    if(c === '(' || c === '[' || c==='{') {
      stack.push(c);
    }

    if(c ===')') {
      if(stack.length===0) {
        return false;
      }
      if(stack.splice(stack.length-1, 1)[0] !== '(') {
        console.log("aa");
        return false;
      }
    }
    if(c ===']') {
      if(stack.length===0) {
        return false;
      }
      if(stack.splice(stack.length-1, 1)[0] !== '[') {
        return false;
      }
    }
    if(c ==='}') {
      if(stack.length===0) {
        return false;
      }
      if(stack.splice(stack.length-1, 1)[0] !== '{') {
        return false;
      }
    }
  }
  if(stack.length!==0) {
    return false;
  }
  else {
    return true;
  }
};

console.log(isValid("()"));

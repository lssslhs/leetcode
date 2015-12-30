/**
* @param {number} x
* @return {number}
*/
var reverse = function(x) {
  var neg = x < 0? true : false;
  if(neg) {
    x = x * -1;
  }
  var result = parseInt(x.toString().split('').reverse().join(''));

  return neg? -1 * result: result;
};

console.log(reverse(1534236469));

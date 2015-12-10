/**
* @param {number[]} nums1
* @param {number[]} nums2
* @return {number}
*/
var findMedianSortedArrays = function(nums1, nums2) {
  var len = nums1.length + nums2.length;
  var mid = parseInt(len/2);
  if(len%2===0) {
    return (findKth(nums1, 0, nums2, 0, mid) + findKth(nums1, 0, nums2, 0, mid+1))/2;
  }
  else {
    return findKth(nums1, 0, nums2, 0, mid+1);
  }
};

var findKth = function(arrA, startA, arrB, startB, k) {
  if(startA>=arrA.length) {
    return arrB[startB+k-1];
  }
  if(startB>=arrB.length) {
    return arrA[startA+k-1];
  }
  if(k===1) {
    return Math.min(arrA[startA], arrB[startB]);
  }
  var mid = parseInt(k/2);
  var valueA = startA + mid -1 >= arrA.length? Number.MAX_VALUE: arrA[startA+mid-1];
  var valueB = startB + mid -1 >= arrB.length? Number.MAX_VALUE: arrB[startB+mid-1];
  if(valueA>valueB) {
    return findKth(arrA, startA, arrB, startB+mid, k - mid);
  }
  else {
    return findKth(arrA, startA + mid, arrB, startB, k - mid);
  }
};

//console.log(findMedianSortedArrays([1,1,1],[1,1,1]));
//console.log(findMedianSortedArrays([],[1]));
console.log(findMedianSortedArrays([1],[2,3,4,5,6]));

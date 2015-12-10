public class MedianOfTwoSortedArray {
  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[0], new int[]{1}));
    System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{2,3,4,5,6}));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length+nums2.length;
    if(len%2==0) {
      return (findKth(nums1, 0, nums2, 0, len/2) + findKth(nums1, 0, nums2, 0, len/2 + 1)) / 2;
    }
    else {
      return findKth(nums1, 0, nums2, 0, len/2 + 1);
    }
  }

  public static double findKth(int[] arrA, int startA, int[] arrB, int startB, int k) {
    if(startA >= arrA.length) {
      return arrB[startB + k - 1];
    }
    if(startB >= arrB.length) {
      return arrA[startA + k - 1];
    }
    if(k==1) {
      return Math.min(arrA[startA], arrB[startB]);
    }

    int valA = startA + k/2 - 1 >= arrA.length? Integer.MAX_VALUE : arrA[startA + k/2 -1];
    int valB = startB + k/2 - 1 >= arrB.length? Integer.MAX_VALUE : arrB[startB + k/2 -1];

    if(valA > valB) {
      return findKth(arrA, startA, arrB, startB + k/2, k - k/2);
    }
    else {
      return findKth(arrA, startA + k/2, arrB, startB, k - k/2);
    }
  }
}

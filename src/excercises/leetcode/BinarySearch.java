package excercises.leetcode;

public class BinarySearch {

  public static void main(String[] args) {
    int target = 9;
    int[] array = new int[] {-1, 0, 3, 5, 9, 12};

//    System.out.println(searchRecursive(array, target, 0, array.length - 1));
    System.out.println(searchIterative(array, target));
  }

  public static int searchRecursive(int[] nums, int target, int left, int right) {
    // ensure to avoid overFlow for big arrays https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
    // e.g. Integer.MAX_VALUE + 1 overflows to negative int that results in unwanted output
    int mid = left + ((right - left) / 2);
    if (right < left)
      return -1;
    if (target == nums[mid]) {
      return mid;
    } else if (target < nums[mid]) {
      return searchRecursive(nums, target, left, mid - 1);
    } else {
      return searchRecursive(nums, target, mid + 1, right);
    }
  }
  
  // prefered than recursion?
  public static int searchIterative(int[] nums, int target) {
    int mid, left = 0, right = nums.length - 1;
    while(left <= right) {
      mid = left + ((right - left) / 2);
      if(target == nums[mid]) return mid;
      if(target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}

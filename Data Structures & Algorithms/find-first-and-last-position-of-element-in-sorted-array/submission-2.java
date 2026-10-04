class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int f = -1, s = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                f = mid;
                r = mid - 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l=0;
        r=nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                s = mid;
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[] {f, s};
    }
}
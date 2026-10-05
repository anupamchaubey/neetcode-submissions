class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = -1;
        int s = -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                f = mid;
                r = mid - 1;
            } else if (target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (f == -1)
            return new int[] {f, s};

        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                s = mid;
                l = mid + 1;
            } else if (target < nums[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return new int[] {f, s};
    }
}
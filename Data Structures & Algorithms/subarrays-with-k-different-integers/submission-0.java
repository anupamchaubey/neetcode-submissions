class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums, k) - atmostK(nums, k - 1);
    }
    int atmostK(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int l = 0;
        int i = 0;
        while (i < nums.length) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

            while (hm.size() > k) {
                hm.put(nums[l], hm.get(nums[l]) - 1);
                if (hm.get(nums[l]) == 0)
                    hm.remove(nums[l]);
                l++;
            }

            cnt += (i - l + 1);
            i++;
        }
        return cnt;
    }
}
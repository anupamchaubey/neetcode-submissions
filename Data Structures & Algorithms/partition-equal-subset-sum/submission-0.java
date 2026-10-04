class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums)sum+=x;
        if(sum%2!=0)return false;
        int target=sum/2;
        return rec(nums, 0, target);
    }
    boolean rec(int[] nums, int idx, int sum){
        if(sum==0)return true;
        if(idx==nums.length)return false;
        return rec(nums, idx+1, sum-nums[idx])|| rec(nums, idx+1, sum);
    }
}

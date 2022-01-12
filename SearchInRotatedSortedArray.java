class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        //binary search
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
// left side is sorted
            else if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target <nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
            else { // right side is sorted
                if(target <= nums[right] && target > nums[mid])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
}
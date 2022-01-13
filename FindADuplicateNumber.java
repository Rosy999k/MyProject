/* 0 1 2 3 4 5 6 7 8 9
   2 5 9 6 9 3 8 9 7 1
two pointer hare tortoise, give second chance to tortoise make hare to traverse one step
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
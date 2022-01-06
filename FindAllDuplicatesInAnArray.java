public class Solution {
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n:nums) {
            int index = Math.abs(n)-1;
            System.out.println(index);
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
            System.out.println(nums[index]);
        }
        return res;
    }
}


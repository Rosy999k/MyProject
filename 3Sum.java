//[-2,-2,-1,-1,-1,0,0,0,2,2,3]
//I/p: [-1,0,1,2,-1,-4]
//After sort: [-4,-1, -1, 0, 1, 2]
//Example-1: [0,0,0]
// For each element in array, do two-pointer approach of finding other complement elements..
// Step-1: Sort array in order to perform two-pointer approach
// Step-2: For each element, get complementary sum
//        If sum matches with two pointers --> add triplet to result and Inc start, decrement end
//        else If two_pointers_sum < sum --> start++
//        else end--

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        //if its standing at the third last index it still can have triplet
        for(int i =0; i< arr.length-2;i++) {
            //if i is first occurence or eliminate duplicates
            if(i == 0 || (i > 0 && arr[i] != arr[i-1])){
                // two pointer approach
                int low=i+1;
                int high=arr.length-1;
                int sum = 0 - arr[i];// -a
                while(low< high){
                    if(arr[low]+arr[high] == sum) {

                        res.add(Arrays.asList(arr[i],arr[low], arr[high]));

                        while( low < high && arr[low] == arr[low+1]) low++; // ignore all -1's
                        while( low < high && arr[high] == arr[high-1]) high--; // all similar ele are ignored
                        low++; // going to next element 0
                        high--;
                    }

                    else if(arr[low]+arr[high] < sum) low++; // adding up to less than sum
                    else high--; // if greater than sum reduce
                }
            }
        }
        return res;
    }
}
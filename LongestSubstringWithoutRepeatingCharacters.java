//use map to store value and location so that you can jump to the element if it already exists in the map
/*naive generate all substrings and find length O(N)^2 space O(N)  using set
optimal : left, right at 0  a b c a a b c d b a check in set if not add to set
range l -r has no repeating characters r - l +1 if there remove a and incremen left pointer and push a
remove b remove c remove a currebt range still has a a move l and after removing a  lr range is 1 push ele next substring is a b c d lr 7-4+1
push d TC O(N+N) each charcter visited twice with l r
best : use map store the index of last b a, 0 a last found at 0th index

 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int right = 0; int left = 0;
        int len = 0;
        int n = s.length();

        while(right < n) {
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1, left);
            }

            map.put(s.charAt(right), right);//storing/ updating last found index
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
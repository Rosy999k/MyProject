//use map to store value and location so that you can jump to the element if it already exists in the map
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

            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
/*Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces
TC O(N) SC O(N) String builder Deque add front and append space while joining
 */
class Solution {
    public String reverseWords(String s) {
        int left= 0; int right = s.length()-1;
        while(left <=right && s.charAt(left) == ' ') {
            left++;
        }
        while(right > 0 && s.charAt(right) == ' ') {
            right--;
        }

        StringBuilder sb = new StringBuilder();
        Deque<String> dq = new LinkedList();
        for(int i = left; i <= right; i++) {
            if(s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
            else if(sb.length() > 0) {
                dq.addFirst(sb.toString()); // add to dq in front
                sb.setLength(0); //reset word
            }
        }
        //     System.out.println(dq);

        dq.addFirst(sb.toString());

        //  System.out.println(dq);
        StringBuilder res = new StringBuilder();
        for(String word : dq) {
            res.append(word).append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}

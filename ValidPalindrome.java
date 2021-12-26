class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <=1)
            return true;
        int i = 0; int j = s.length() -1;
        while(i<j)
        {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i++))!= Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}
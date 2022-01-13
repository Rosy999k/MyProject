/* a a b b c c c
  ij j j
j-i    i j j

a
 */
class Solution {
    public int compress(char[] chars) {
        int index=0;
        int i = 0;
        while(i < chars.length){
            int j=i;
            while(j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            chars[index++] = chars[i];
            if(j - i > 1) // eliminates a 1 if only occurs once
            {
                String count = j -i + "";
                for (char c: count.toCharArray()) {
                    chars[index++]=c;
                }
            }
            i=j;
        }
        return index;
    }
}

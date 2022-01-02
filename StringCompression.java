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
            if(j - i > 1)
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

//class Solution {
//    public int compress(char[] chars) {
//        int index= 0;
//        for(int i = 0; i< chars.length;i++) {
//            chars[index++] = chars[i];
//            int start = i;
//            while(i+1 < chars.length && chars[start] == chars[i+1]) {
//                i++;
//            }
//            int count = i-start+1;
//            if(count == 1) continue;
//            if(count < 10) chars[index++] = (char)(count+'0');
//            else
//                for(char c : String.valueOf(count).toCharArray()) {
//                    chars[index++]=c;
//                }
//        }
//        return index;
//    }
//
//}
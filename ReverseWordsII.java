class Solution {
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);
        for(int i=0,j=0;i<=s.length;i++){
            if(i==s.length || s[i]==' '){// last word doesmpt end with space
                reverse(s,j,i-1);
                j=i+1;
            }
        }


    }

    public void reverse(char[] s, int start, int end){
        for(int i=start, j=end; i<j; i++,j--){
            char temp=s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}


//     public void reverseWords(char[] s) {
//       StringBuilder word=new StringBuilder();
//       Deque<String> words=new ArrayDeque<>();
//       for(char ch:s){
//         if(ch !=' '){
//           word.append(ch);
//         }else{
//           words.offerFirst(word.toString());
//           word.setLength(0);
//         }
//       }
//       words.offerFirst(word.toString());

//       String res=String.join(" ",words);
//       int index=0;
//       for(char ch:res.toCharArray()){
//         s[index++] =ch;
//       }
//     }

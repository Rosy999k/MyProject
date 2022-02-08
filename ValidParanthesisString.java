class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0; // open parentheses count in range [cmin, cmax]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++; // if `*` become `(` then openCount++
                cmin--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }
            if (cmax < 0) return false; // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            // For example: ())(
            cmin = Math.max(cmin, 0);   // It's invalid if open parentheses count < 0 that's why cmin can't be negative
        }
        return cmin == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
    }
}
//
//class Solution {
//    public:
//    bool checkValidString(string s) {
//
//        stack<int> open,star;
//        int len = s.length();
//
//        for(int i=0;s[i]!='\0';++i)
//        {
//            if(s[i]=='(')
//                open.push(i);
//            else if(s[i]=='*')
//                star.push(i);
//            else
//            {
//                if(!open.empty())
//                    open.pop();
//                else if(!star.empty())
//                    star.pop();
//                else
//                    return false;
//            }
//        }
//
//        //Now process leftover opening brackets
//        while(!open.empty())
//        {
//            if(star.empty())
//                return false;
//            else if(open.top() < star.top())
//            {
//                open.pop();
//                star.pop();
//            }
//            else    //CASE: open.top() > star.top()
//                return false;
//        }
//        return true;
//    }
//};
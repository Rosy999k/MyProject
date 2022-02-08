class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for(int j=1; j<strs.length;j++)
        {
            char[] currentWord = strs[j].toCharArray();

            if(currentWord.length < result.length())
            {
                result = result.substring(0, currentWord.length);
            }

            for(int k=0; k<result.length(); k++)
            {
                if(currentWord[k]!= result.charAt(k))
                {
                    result = result.substring(0, k);
                    break;
                }
            }
        }

        return result;
    }
}
class Solution {
    public int minDeletions(String s) {
        int charCount[] = new int[26], deletions = 0;
        Set<Integer> used = new HashSet<>();
        for (char ch:s.toCharArray())
            charCount[ch - 'a']++;
        for (int freq:charCount) {
            while (freq != 0 && used.contains(freq)) {
                freq--;
                deletions++;
            }
            used.add(freq);
        }
        return deletions;
    }
}
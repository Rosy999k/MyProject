// Strings can contain characters of any type..

// Step-1: Sort each string
// Step-2: Initialize Map<String, List<String>> -- key is sorted string and map is anagrams related to sorted string
// return new ArrayList<>(map.values());
TCO(KlogK)Neach string N is length of strs sc O(NK)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String current : strs) {
            char [] characters = current.toCharArray();
            Arrays.sort(characters);
            String sorted = String.valueOf(characters);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(current);
        }
        return new ArrayList<>(map.values());
    }
}
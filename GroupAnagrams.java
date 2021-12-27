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
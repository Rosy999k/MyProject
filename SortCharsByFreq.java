class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(frequency.entrySet());
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 0) {
            Map.Entry<Character, Integer> entry = maxHeap.remove();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
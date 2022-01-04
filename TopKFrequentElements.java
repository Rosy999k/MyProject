class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countByNum = new HashMap<>();
        for(int num : nums) {
            countByNum.put(num, countByNum.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((num1, num2)->
                Integer.compare(countByNum.get(num1), countByNum.get(num2)));

        for(int key : countByNum.keySet()) {
            minHeap.add(key);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] topK = new int[k];
        for(int i=0; i<k;i++) {
            topK[i] = minHeap.poll();
        }

        return topK;
    }
}
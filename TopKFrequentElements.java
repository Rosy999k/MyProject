/*
Initialize a map
iterate to put elements as key and occurence as value
Initialize a queue with custom comparator
Add all keys into queue based on increasing order of occurence
Remove value from queue till size is > than K
Iterate over the queue and take value in array to return it
 */

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
class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> counter =  new HashMap<>();

        for(String str: words)
        {
            counter.put(str, counter.getOrDefault(str, 0)+1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((str1, str2) -> counter.get(str1)==counter.get(str2)? str2.compareTo(str1): Integer.compare(counter.get(str1), counter.get(str2)));

        for(String str: counter.keySet())
        {
            heap.offer(str);
            if(heap.size()>k)
            {
                heap.poll();
            }
        }

        List<String> result= new ArrayList();

        while(!heap.isEmpty())
        {
            result.add(0, heap.poll());
        }
        return result;
    }
}

//    Map<String,Integer> count=new HashMap<>();
//    for(String word:words){
//            count.put(word,count.getOrDefault(word,0)+1);
//            }
//
//            System.out.println(count);
//            List<String> topKFrequentWords=new ArrayList(count.keySet());
//        Collections.sort(topKFrequentWords,(a,b)->(count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));
//
//        System.out.println(topKFrequentWords);
//        return  topKFrequentWords.subList(0,k);
//
//        }

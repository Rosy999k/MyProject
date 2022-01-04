/*
3 steps while pushing the elements
1. Update freq in freqMap
2.Update maxFreq if applicable
3.Add value to freq stack

3 steps while popping
1.return and remove top element of stack where is key is maxFreq
2.if stack becomes empty reduce maxFreq
3.reduce count from the map
*/
class FreqStack {
    Map<Integer, Integer> freqMap = new HashMap<>();
    Map<Integer, Stack<Integer>> freqStack = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {

    }

    public void push(int x) {
        int freq = freqMap.getOrDefault(x,0)+1;
        freqMap.put(x, freq);
        if(freq > maxFreq) maxFreq = freq;
        freqStack.computeIfAbsent(freq, z-> new Stack()).push(x);
    }


    //return remove top of max Freq
    //update maxFreq
    //update map
    public int pop() {
        int x = freqStack.get(maxFreq).pop();
        int freq = freqMap.get(x) -1;
        freqMap.put(x, freq);
        if(freqStack.get(maxFreq).size() == 0) maxFreq--;
        return x;
    }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
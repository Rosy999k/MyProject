class MyQueue {
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // shift input to output
        if (output.empty())
            while (input.empty() == false)
            {
                output.push(input.peek());
                input.pop();
            }


        int x = output.peek();
        output.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        // shift input to output
        if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

//class MyQueue {
//    Stack<Integer> stack1=new Stack<Integer>();
//    Stack<Integer> stack2=new Stack<Integer>();
//
//
//    /** Initialize your data structure here. */
//    public MyQueue() {
//
//    }
//
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        while(!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
//        stack1.push(x);
//        while(!stack2.isEmpty()){
//            stack1.push(stack2.pop());
//        }
//    }
//
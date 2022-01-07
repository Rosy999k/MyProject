import java.util.*;

class MyQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int maxSize;
    private int count;

    public MyQueue(int size){
        this.maxSize = size;
        this.queueArray = new int[size];
        front = 0;
        rear = 0;
        count=0;
    }


    public void insert (int val) {
        if (isQueueFull()) {
            System.out.println("queue is full");
            return;
        } else {
            rear = (rear+1)%maxSize;
            queueArray[rear] = val;
            count++;
            System.out.println("Item added to queue " +val);
        }
    }

    public int delete(){
        if(isQueueEmpty()) {
            return -1;
        }
        else {
            front = (front+1)%maxSize;
            int temp = queueArray[front];
            count--;
            System.out.println("Item deleted from queue " +temp);
            return  temp;
        }
    }

    public int top() {
        if(count == 0 || front == rear ) {
            return -1;
        } else {
            front = (front)%maxSize;

            System.out.println("Top element from queue " + queueArray[front]);
            return queueArray[front];
        }
    }

    public boolean isQueueFull(){
        return (maxSize == count);
    }

    public boolean isQueueEmpty(){
        return (count == 0);
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue(5);
        queue.insert(3);
        queue.insert(2);
        queue.insert(1);
        queue.insert(8);
        queue.insert(7);
        queue.insert(6);
        queue.top();
        queue.delete();
        queue.top();
        queue.delete();
        queue.top();
        queue.top();

    }
}